package app4_socket_method_obj.material;

public class SocketMethod2ObjServiceImpl implements SocketMethod2ObjService {
    private final String name;  
    private final int age;  
  
    public SocketMethod2ObjServiceImpl(String name, int age) {
        this.name = name;  
        this.age = age;
    }  
  
    @Override  
    public String getName() {  
        return name;  
    }  
  
    @Override  
    public int getAge() {  
        return age;  
    }  

    public SocketMethod2ObjBean getBean(String name, int age){
        return new SocketMethod2ObjBean(name,age);
    }
}  