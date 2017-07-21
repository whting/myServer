import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ThreadBatch {

    //    static int count = 0;// 误差 99984/100000
    static volatile int count = 0;// not Atomic 99992/100000
    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++)
                        System.out.println(count++ + "|" + atomicInteger.getAndIncrement());
                }
            };
        }

        // 并行启动
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        // java8 Stream
        Stream.of("t1", "t2").forEach(name -> new Thread(name) {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start());

        // java8 Arrays to stream
        Arrays.asList("m1","m2","m3","m4","m5").stream().forEach(name -> new Thread(name) {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start());
    }
}
