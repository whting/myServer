package app3_socket_method_str2;

public class PersonClient {
    public static void main(String [] args) {
        try {  
            Person person = new Person_Stub();
            int age = person.getAge();
            String name = person.getName();
            System.out.println(name + " is " + age + " years old");
        } catch(Throwable t) {
            t.printStackTrace();
        }  
    }  
}  