package app2_socket_implObj;

import java.io.ObjectInputStream;
import java.net.Socket;

public class EjbSockClent {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9000);
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        EjbBean eBean = (EjbBean) inputStream.readObject();
        System.out.println("老婆接受到对象---对象姓名：" + eBean.getName() + "对象年龄：" + eBean.getAge());
    }

}  