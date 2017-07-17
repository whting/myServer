package threadGroup;

public class ThreadGroupTest {

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getName() + " " + t.getThreadGroup());

        System.out.println(Thread.activeCount());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        Thread[] temp = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(temp);

        for (Thread thread : temp) {
            System.out.println(thread);
        }

    }
}
