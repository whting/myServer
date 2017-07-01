package app3_socket_method_str;

import app3_socket_method_str.material.EjbSenssicBean;
import app3_socket_method_str.material.EjbSenssicBeanImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EjbSenssicSer extends Thread {
    private final EjbSenssicBean eBean;
    private final Socket socket;

    public EjbSenssicSer(EjbSenssicBean eBean, Socket socket) {
        this.eBean = eBean;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            while (socket != null) {
                ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
                String method = (String) iStream.readObject();
                if (method.equals("age")) {
                    ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        oStream.writeInt(eBean.getAge());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                    oStream.flush();
                }

                if (method.equals("name")) {
                    ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        oStream.writeObject(eBean.getName());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                    oStream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        ServerSocket serSocket = new ServerSocket(9000);
        EjbSenssicBean eBean = new EjbSenssicBeanImpl("senssic", 20);
        while (true) {
            Socket socket = serSocket.accept();
            EjbSenssicSer ejbSenssicSer = new EjbSenssicSer(eBean, socket);
            ejbSenssicSer.start();
        }

    }

}  