


public class SimpleClass {
    public void sayHello() {
        System.out.println("Hello");
    }
}

/**
 * # 查看编译后的SimpleClass类常量(constants)信息
 * myServer\@jvm\demo-jvm\target\classes>javap -v -p -s -sysinfo -constants SimpleClass.class
 * 或
 * myServer\@jvm\demo-jvm\target\classes>javap -v -p -s SimpleClass.class
 * <p>
 * 参考:
 * `JVM内幕：Java虚拟机详解 - ImportNew`
 * http://www.importnew.com/17770.html
 */