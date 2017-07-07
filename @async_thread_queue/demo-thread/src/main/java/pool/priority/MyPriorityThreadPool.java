package pool.priority;

import java.text.MessageFormat;
import java.util.concurrent.*;

/**
 * [简单封装]依据任务优先级,可插队的线程池
 */
public class MyPriorityThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPool_demo().executor();

        boolean coreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();// 将包括“核心线程”在内的，没有任务分配的任何线程，在等待keepAliveTime时间后全部进行回收
        System.out.println("coreThreadTimeOut:" + coreThreadTimeOut);// 默认是false

        String config = MessageFormat.format("配置:corePoolSize:{0} maximumPoolSize:{1} Queue-MaxSize:{2}"
                , threadPoolExecutor.getCorePoolSize()
                , threadPoolExecutor.getMaximumPoolSize()
                , threadPoolExecutor.getQueue().remainingCapacity());
        System.out.println(config);
        System.out.println("说明:[<ActiveCount>/<MaximumPoolSize>/<Queue-Size>]");
        Thread.sleep(1000);

        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.getQueue().size();

            String info = MessageFormat.format("{0}:[{1}/{2}/{3}]"
                    , i, threadPoolExecutor.getActiveCount()
                    , threadPoolExecutor.getMaximumPoolSize()
                    , threadPoolExecutor.getQueue().size());
            System.out.println(info);

            /* 常规线程(先进先出-LinkedTransferQueue[CAS乐观锁]) */
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "正在执行。。。");
//                }
//            });

            /* 优先级控制线程(依优先级插队-PriorityBlockingQueue)|仅作用在未开始的线程,故注意corePoolSize */
            threadPoolExecutor.execute(new MyRunnableComp((int) (1000 + Math.random() * (9999 - 1000 + 1))));// 首个立即执行
        }
    }
}

class ThreadPool_demo {
    int corePoolSize = 5;// 核心线程(产生后不释放待复用)
    int maximumPoolSize = 20;// 最大池(核心线程数+临时线程数) (超过最大线程池,将抛出异常RejectedExecutionException)
    long keepAliveTime = 0l;// 空闲时间(多出corePoolSize的线程在空闲时间超过 keepAliveTime 时将会终止)
    TimeUnit unit = TimeUnit.MILLISECONDS;// 单位 毫秒 纳秒

//    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);// 固定队列容量(当塞入线程超过队列容量,将立即执行掉)
//     BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();// 双链表,无限队列大小/ 不会有多于corePoolSize的线程被创建,maximumPoolSize没意义
//     BlockingQueue<Runnable> workQueue = new LinkedTransferQueue<Runnable>();// 无锁方式-CAS ★
     BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();// 同步
//    BlockingQueue<Runnable> workQueue = new PriorityBlockingQueue<Runnable>();// 优先级

    public ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}

/**
 * 优先级可控的线程池
 */
class MyRunnableComp implements Runnable, Comparable<MyRunnableComp> {
    int priority;// 优先级

    public MyRunnableComp(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "[" + this.priority + "]" + "正在执行。。。");
        try {
            Thread.sleep(3000);// 延长任务完成时间,给优先级排序预留时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 顺序控制
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(MyRunnableComp o) {
        if (o.getPriority() == this.priority) {
            return 0;
        }
        return o.getPriority() > this.priority ? -1 : 1;
    }
}

/**
 * Java线程池揭秘 - 推酷
 * http://www.tuicool.com/articles/32632uB
 * <p>
 * Java线程池总结 - 推酷
 * http://www.tuicool.com/articles/e2aUvyR
 * <p>
 * PriorityBlockingQueue | 并发编程网 – ifeve.com
 * http://ifeve.com/tag/priorityblockingqueue/
 * <p>
 * Java 7中的TransferQueue | 并发编程网 – ifeve.com
 * http://ifeve.com/java-transfer-queue/
 */