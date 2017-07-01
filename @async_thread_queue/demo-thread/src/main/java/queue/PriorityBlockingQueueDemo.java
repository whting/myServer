package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;


class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;

    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        //复写此方法进行任务执行优先级排序  
//      return priority < o.priority ? 1 :  
//          (priority > o.priority ? -1 : 0);  
        if (priority < o.priority) {
            return -1;
        } else {
            if (priority > o.priority) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public void run() {
        //执行任务代码..  
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {

        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task id : " + id;
    }

    public String summary() {
        return "( Task id : " + id + " _priority : " + priority + ")";
    }

    /**
     * 结束所有任务
     */
    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentinel(ExecutorService e) {
            super(Integer.MAX_VALUE);
            exec = e;
        }

        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                System.out.print(pt.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + "Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

/**
 * 制造一系列任务,分配任务优先级
 */
class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        queue = q;
        exec = e;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }

        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }

            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }

            queue.add(new PrioritizedTask.EndSentinel(exec));

        } catch (InterruptedException e) {

        }

        System.out.println("Finished PrioritizedTaskProducer");
    }
}


/**
 * 使用PriorityBlockingQueue进行任务按优先级同步执行
 */
class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }

}

public class PriorityBlockingQueueDemo {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();

        exec.execute(new PrioritizedTaskProducer(queue, exec));
        TimeUnit.MILLISECONDS.sleep(250);
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}

/**
 * 使用PriorityBlockingQueue进行任务按优先级同步执行,摘自Think in Java - forever_crying的专栏 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/forever_crying/article/details/8071014
 */
