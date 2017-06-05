package socket_thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class FilmClient {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            Client client = new Client();
            client.i = i;
            client.start();
        }
    }
}

class Client extends Thread {

    int i;

    @Override
    public void run() {

        Date date = new Date();

        // 1.建立scoket连接
        Socket client;
        try {
            client = new Socket("127.0.0.1", 8089);

            // 2.打开socket的流信息，准备下面的操作
            OutputStream os = client.getOutputStream();

            // 3.写信息
            os.write(("d://film//音乐.rar").getBytes());   //这个是服务器端的文件地址

            String filmName = "e://io" + i + ".rar";  //这是要下载到客户端的地址及文件名,这里相当于下载了两遍2.rmvb，只不过保存在客户端的时候起了两个不同的文件名，方便比较

            FileOutputStream fileOutputStream = new FileOutputStream(filmName);


            System.out.println("Time=" + date.getTime());
            InputStream is = client.getInputStream();// 接收服务器端的文件并写到客户端,这里会一直等服务器端发消息过来，如果服务器sleep10秒才发送过来，客户端也会一直等，
            // 这就导致整个线程都会阻塞在这里
            byte b[] = new byte[1024];

            while (is.read(b) > 0) {
                fileOutputStream.write(b);
            }

            // 4.关闭socket
            // 先关闭输出流
            os.close();

            // 最后关闭socket
            client.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Time1=" + date.getTime());
    }

}