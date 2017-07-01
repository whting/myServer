package app4_socket_method_obj;

import app4_socket_method_obj.material.SocketMethod2ObjBean;
import app4_socket_method_obj.material.SocketMethod2ObjService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketMethod2ObjClent implements SocketMethod2ObjService {
    private Socket socket;

    public SocketMethod2ObjClent() {
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

    /**
     * 序列化回调的对象
     *
     * @param name
     * @param age
     * @return
     * @throws Throwable
     */
    public SocketMethod2ObjBean getBean(String name, int age) throws Throwable {
        ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
        Object[] methodInfo = {"getBean", name, age};
        oStream.writeObject(methodInfo);
        ObjectInputStream InputStream = new ObjectInputStream(socket.getInputStream());
        SocketMethod2ObjBean socketMethod2ObjBean = (SocketMethod2ObjBean) InputStream.readObject();
        oStream.flush();
        return socketMethod2ObjBean;
    }

    public static void main(String[] args) throws Throwable {
        /* 远程Service一般由RPC框架提供被代理的实现类(代理方法内容就是tcp访问远程方法,并完成序列化工作) */
        SocketMethod2ObjService eBean = new SocketMethod2ObjClent();
        SocketMethod2ObjBean socketMethod2ObjBean = eBean.getBean("lili", 12);
        System.out.println("远方的名字：" + socketMethod2ObjBean.getName() + "远方的年龄：" + socketMethod2ObjBean.getAge());
    }

}  