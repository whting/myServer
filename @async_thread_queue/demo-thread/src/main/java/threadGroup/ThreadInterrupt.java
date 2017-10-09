package threadGroup;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.interrupted()) {
                        break;
                    }
                }
            }
        };

        t.start();
        Thread.sleep(3000);
        t.interrupt();// 打断
    }
}

/**
 * 汪文君高并发编程第一阶段15讲-Thread中断Interrupt方法详细讲解
 * http://pan.baidu.com/play/video#video/path=%2F%E6%B1%AA%E6%96%87%E5%90%9B%E5%A4%9A%E7%BA%BF%E7%A8%8B%2F%E6%B1%AA%E6%96%87%E5%90%9B%E5%A4%9A%E7%BA%BF%E7%A8%8B%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98%E8%A7%86%E9%A2%91-%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5%2F%E6%B1%AA%E6%96%87%E5%90%9B%E9%AB%98%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B515%E8%AE%B2-Thread%E4%B8%AD%E6%96%ADInterrupt%E6%96%B9%E6%B3%95%E8%AF%A6%E7%BB%86%E8%AE%B2%E8%A7%A3.wmv&t=-1
 *
 * 汪文君高并发编程第一阶段17讲-Thread API综合实战，编写ThreadService实现暴力结束线程的综合实战
 * http://pan.baidu.com/play/video#video/path=%2F%E6%B1%AA%E6%96%87%E5%90%9B%E5%A4%9A%E7%BA%BF%E7%A8%8B%2F%E6%B1%AA%E6%96%87%E5%90%9B%E5%A4%9A%E7%BA%BF%E7%A8%8B%E7%BC%96%E7%A8%8B%E5%AE%9E%E6%88%98%E8%A7%86%E9%A2%91-%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5%2F%E6%B1%AA%E6%96%87%E5%90%9B%E9%AB%98%E5%B9%B6%E5%8F%91%E7%BC%96%E7%A8%8B%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B517%E8%AE%B2-Thread%20API%E7%BB%BC%E5%90%88%E5%AE%9E%E6%88%98%EF%BC%8C%E7%BC%96%E5%86%99ThreadService%E5%AE%9E%E7%8E%B0%E6%9A%B4%E5%8A%9B%E7%BB%93%E6%9D%9F%E7%BA%BF%E7%A8%8B%E7%9A%84%E7%BB%BC%E5%90%88%E5%AE%9E%E6%88%98.wmv&t=-1
 */