package app4_socket_method_obj.material;

import java.io.Serializable;

public class SocketMethod2ObjBean implements Serializable {

    private final String name;
    private final int age;

    public SocketMethod2ObjBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
