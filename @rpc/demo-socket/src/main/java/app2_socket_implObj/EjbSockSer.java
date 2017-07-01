package app2_socket_implObj;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;  
  
public class EjbSockSer extends Thread {  
    private final EjbBean eBean;  
    private final Socket socket;  
  
    public EjbSockSer(EjbBean eBean, Socket socket) {  
        this.eBean = eBean;  
        this.socket = socket;  
    }  
  
    @Override  
    public void run() {  
        try {  
  
            while (socket != null) {  
                ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
                oStream.writeObject(eBean);  
                System.out.println("发给老婆的对象完成。。。");  
                oStream.flush();  
                oStream.close();  
            }  
        } catch (Exception e) {  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        EjbBean eBean = new EjbBean();  
        eBean.setAge(20);  
        eBean.setName("senssic");  
        ServerSocket serSocket = new ServerSocket(9000);  
        System.out.println("今天女朋友生气了，哎，启动女朋友服务！");  
        while (true) {  
            System.out.println("启动一个爱老婆线程………………");  
            Socket socket = serSocket.accept();  
            System.out.println("爱老婆服务完成。");  
            EjbSockSer eSer = new EjbSockSer(eBean, socket);  
            eSer.start();  
        }  
    }  
}  