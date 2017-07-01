package app3_socket_method_str2;

public class PersonServer implements Person {
    int age;  
    String name;  
  
    public PersonServer(String name, int age) {
        this.age = age;  
        this.name = name;  
    }  
  
    public int getAge() {
        return age;  
    }  
  
    public String getName() {
        return name;  
    }  
}  