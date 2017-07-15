import java.util.concurrent.atomic.AtomicInteger;

public class ThreadBatch {

//    static int count = 0;// 误差 99984/100000
    static volatile int count = 0;// not Atomic 99992/100000
    static AtomicInteger atomicInteger=new AtomicInteger();

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++)
                        System.out.println(count++ + "|" + atomicInteger.getAndIncrement());
                }
            };
        }

        // 并行启动
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
