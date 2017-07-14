package lock.readWriteLock;

public class MainReadWritLockTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final ReadWriteLockTest rwlt = new ReadWriteLockTest();
        for(int i=0; i<50;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    rwlt.get();
                }
            }).start();
        }
        for(int i=0; i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    rwlt.put();
                }
            }).start();
        }
    }

}