package app3_socket_method_str.material;

public class EjbSenssicBeanImpl implements EjbSenssicBean {
    private final String name;  
    private final int age;  
  
    public EjbSenssicBeanImpl(String name, int age) {  
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
  
}  