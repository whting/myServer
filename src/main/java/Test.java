/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class Test {
    public static void main(String[] args) {

//        ClassLoader.loadClass(className)
        try {
//            ClassLoader.loadClass("");
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
