package join;

public class ThreadJoin {

    static void demo() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("~");
            }
        };
        t.start();
        t.join();// 等待线程结束
        System.out.println("---");
    }


    public static void main(String[] args) throws InterruptedException {
        demo();
    }
}
