package serializable;

import java.io.*;

public class MyTest_static implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "SheepMu";
    private static int age = 24;

    public static void main(String[] args) {
        //以下代码实现序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.out"));//输出流保存的文件名为 my.out ；ObjectOutputStream能把Object输出成Byte流 
            MyTest_static myTest = new MyTest_static();
            oos.writeObject(myTest);
            oos.flush();  //缓冲流  
            oos.close(); //关闭流 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fan();//调用下面的  反序列化  代码 
    }

    public static void fan() {
        new MyTest_static().name = "SheepMu_1";//!!!!!!!!!!!!!!!!重点看这两行 更改部分
        age = 1;
        ObjectInputStream oin = null;//局部变量必须要初始化
        try {
            oin = new ObjectInputStream(new FileInputStream("my.out"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        MyTest_static mts = null;
        try {
            mts = (MyTest_static) oin.readObject();//由Object对象向下转型为MyTest对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("name=" + mts.name);// SheepMu
        System.out.println("age=" + mts.age);// 1
    }
}