package app2_socket_implObj;

import java.io.Serializable;
  
//因为是整个序列化，必须实现序列化接口，否则会报错  
public class EjbBean implements Serializable {  
  
    private static final long serialVersionUID = 1L;  
    private String name;  
    private int age;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
}  