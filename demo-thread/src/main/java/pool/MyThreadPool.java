package pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new Main().executor();

        boolean coreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();// 将包括“核心线程”在内的，没有任务分配的任何线程，在等待keepAliveTime时间后全部进行回收
        System.out.println(coreThreadTimeOut);// 默认是false

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行。。。");
                }
            });
        }
    }
}

class Main {
    int corePoolSize = 5;// 核心线程(产生后不释放待复用)
    int maximumPoolSize = 10;// 最大池(核心线程数+临时线程数)
    long keepAliveTime = 0l;// 空闲时间(多出corePoolSize的线程在空闲时间超过 keepAliveTime 时将会终止)
    TimeUnit unit = TimeUnit.MILLISECONDS;// 单位 毫秒 纳秒

    // 在这种策略(LinkedBlockingQueue)下，不会有多于corePoolSize的线程被创建，所以maximumPoolSize也就没有任何意义了。调用 Executors.newFixedThreadPool 生成的线程池是这个策略
    BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();// LinkedBlockingQueue SynchronousQueue

    //ThreadFactory threadFactory = Executors.defaultThreadFactory();
    // RejectedExecutionHandler handler = new AbortPolicy();

    public ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}

/**
 * Java线程池揭秘 - 推酷
 * http://www.tuicool.com/articles/32632uB
 *
 * Java线程池总结 - 推酷
 * http://www.tuicool.com/articles/e2aUvyR
 */