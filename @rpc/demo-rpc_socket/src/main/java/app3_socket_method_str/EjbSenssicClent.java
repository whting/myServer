package app3_socket_method_str;

import app3_socket_method_str.material.EjbSenssicBean;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EjbSenssicClent implements EjbSenssicBean {
    private Socket socket;

    public EjbSenssicClent() {
        try {
            socket = new Socket("127.0.0.1", 9000);
        } catch (Exception e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    @Override
    public String getName() throws Throwable {
        ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
        oStream.writeObject("name");
        ObjectInputStream InputStream = new ObjectInputStream(socket.getInputStream());
        String name = (String) InputStream.readObject();
        oStream.flush();
        return name;
    }

    @Override
    public int getAge() throws Throwable {
        ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
        oStream.writeObject("age");
        ObjectInputStream InputStream = new ObjectInputStream(socket.getInputStream());
        int age = InputStream.readInt();
        oStream.flush();
        return age;
    }

    public static void main(String[] args) throws Throwable {
        EjbSenssicBean eBean = new EjbSenssicClent();
        System.out.println("远方的名字：" + eBean.getName() + "远方的年龄：" + eBean.getAge());
    }

}  