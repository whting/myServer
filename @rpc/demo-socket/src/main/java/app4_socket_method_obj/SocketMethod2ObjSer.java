package app4_socket_method_obj;

import app4_socket_method_obj.material.SocketMethod2ObjService;
import app4_socket_method_obj.material.SocketMethod2ObjServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketMethod2ObjSer extends Thread {
    private final SocketMethod2ObjService eBean;
    private final Socket socket;

    public SocketMethod2ObjSer(SocketMethod2ObjService eBean, Socket socket) {
        this.eBean = eBean;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            while (socket != null) {
                ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
                Object[] methodInfo = (Object[]) iStream.readObject();

                Class[] cls = new Class[methodInfo.length - 1];
                Object[] objs = new Object[methodInfo.length - 1];
                for (int i = 1; i < methodInfo.length; i++) {
                    cls[i - 1] = methodInfo[i].getClass() == Integer.class ? int.class : methodInfo[i].getClass();
                    objs[i - 1] = methodInfo[i];
                }

                Method addMethod = eBean.getClass().getMethod((String) methodInfo[0], cls);// 反射执行目标
                Object result = addMethod.invoke(eBean, objs);// 调用

                // 回写
                ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
                oStream.writeObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        ServerSocket serSocket = new ServerSocket(9000);
        SocketMethod2ObjService eBean = new SocketMethod2ObjServiceImpl("senssic", 20);
        while (true) {
            Socket socket = serSocket.accept();
            SocketMethod2ObjSer ejbSenssicSer = new SocketMethod2ObjSer(eBean, socket);
            ejbSenssicSer.start();
        }

    }

}  