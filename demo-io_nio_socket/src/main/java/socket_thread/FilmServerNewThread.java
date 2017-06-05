package socket_thread;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 以上的Server就是在原始的socket基础上加了线程，每一个Client请求过来后，整个Server主线程不必处于阻塞状态，
 * 接收请求后直接另起一个新的线程来处理和客户端的交互，就是往客户端发送二进制包。这个在新线程中虽然阻塞，
 * 但是对于服务主线程没有阻塞的影响，主线程依然通过死循环监听着客户端的一举一动。
 * 另一个客户端的线程发起请求后就再起一个新的线程对象去为客户端服务。
 */
public class FilmServerNewThread {

    public static void main(String[] args) {
        FilmServerNewThread ms = new FilmServerNewThread();
        try {
            ms.server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器端响应请求
     *
     * @throws Exception
     */
    public void server() throws Exception {

        // 0.建立服务器端的server的socket
        ServerSocket ss = new ServerSocket(8089);

        while (true) {

            // 1.打开socket连接
            // 等待客户端的请求
            final Socket server = ss.accept();

            System.out.println("服务-----------请求开始start");

            // 2.打开socket的流信息，准备下面的操作
            final InputStream is = server.getInputStream();
            byte b[] = new byte[1024];
            int readCount = is.read(b);

            String str = new String(b);

            str = str.trim();

            final String serverFileName = str;

            // 3.对流信息进行读写操作
            System.out.println("客户端传过来的信息是：" + str);

            if (readCount > 0) {
                new Thread() {

                    @Override
                    public void run() {
                        System.out.println("线程" + Thread.currentThread().getName() + "启动");
                        try {
                            FileInputStream fileInputStream = new FileInputStream(serverFileName);

                            // 3.1 服务器回复客户端信息(response)
                            OutputStream os = server.getOutputStream();

                            byte[] bfile = new byte[1024];

                            // 往客户端写
                            while (fileInputStream.read(bfile) > 0) {
                                os.write(bfile);
                            }

                            fileInputStream.close();

                            os.close();

                            // 4.关闭socket
                            // 先关闭输入流
                            is.close();

                            // 最后关闭socket
                            server.close();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            System.out.println("服务-----------请求结束over");
        }

    }
}  