public class InstanceofData {

    static void instanceof_m() {
        Object object = 1.1;
        System.out.println(object instanceof Integer);// false
        System.out.println(object instanceof Object);// true
        System.out.println(object instanceof String);// false
    }

    static void classEquale_m() {
        Object object = 1.1, objf = 1.2f;
        System.out.printf("[%s] %s", object.getClass(), object.getClass().equals(Integer.class)).println();
        System.out.printf("[%s] %s", object.getClass().getName(), object.getClass().equals(Object.class)).println();
        System.out.printf("[%s] %s", object.getClass().getSimpleName(), object.getClass().equals(String.class)).println();
        System.out.printf("[%s] %s", objf.getClass().getSimpleName(), objf.getClass().equals(Float.class)).println();

        /**
         * 获取父类的类型信息：getSuperclass()
         * 获取实现的接口的类型信息：getInterfaces()
         * 获取类型名称：getName()、getSimpleName()、getCanonicalName()
         */
    }

    public static void main(String[] args) {
        instanceof_m();
        classEquale_m();
    }
}

/**
 * `Java中对象的类型判断`
 * http://blog.csdn.net/shikangkai/article/details/50273527
 */