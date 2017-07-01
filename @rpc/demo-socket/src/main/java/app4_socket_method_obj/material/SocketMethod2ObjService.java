package app4_socket_method_obj.material;

public interface SocketMethod2ObjService {
    public String getName() throws Throwable;

    public int getAge() throws Throwable;

    public SocketMethod2ObjBean getBean(String name, int age) throws Throwable;
}  