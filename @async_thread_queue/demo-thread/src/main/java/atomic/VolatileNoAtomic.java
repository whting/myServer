package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不具备synchronized关键字的原子性（同步）
 * AtomicInteger具备原子性（同步）
 */
public class VolatileNoAtomic extends Thread{
    //private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);
    private static void addCount(){
        for (int i = 0; i < 1000; i++) {
            //count++ ;
            count.incrementAndGet();
        }
        System.out.println(count);// 打印会有延迟，最终结果是10000
    }

    public void run(){
        addCount();
    }

    public static void main(String[] args) {

        VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}