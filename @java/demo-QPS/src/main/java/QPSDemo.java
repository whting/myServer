import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxiang on 2017/8/30.
 */
public class QPSDemo {


    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    static void cpuCompute(long timeGlob) {
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < 100) {/* 100ms的循环计算 */}
        long runtime = System.currentTimeMillis() - timeGlob;
        System.out.println(Thread.currentThread().getName()+":"+runtime+" "+atomicInteger.get());
        if(runtime<1000){
            atomicInteger.incrementAndGet();
        }
    }

    static void cpuComputePool(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1000);
        final long[] timeGlob = {0};
        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    if(timeGlob[0] == 0){
                        timeGlob[0] = System.currentTimeMillis();
                    }
                    cpuCompute(timeGlob[0]);
                }
            });
        }
    }

    public static void main(String[] args) {
        cpuCompute(System.currentTimeMillis());// 单线程
        System.out.println("======");
        cpuComputePool();// 多线程

    }
}
