package create.singleton.process.liuxiang;

class MySingleton_Static {

    // 初始化时机：当任意static被被访问时,会初始化实例(建议initInstall)。否则将在getInstall访问时才创建(非饿加载)
    public static int initInstall = 1;// (理解并不直观,所以不见得好/ 避免此类影响可结合static内部类实例化当前类,getInstall中触发.如下文)

    /* 考虑类加载机制的初始化条件(被new或内部static被访问),所以启动时并不会实例化*/
    private static MySingleton_Static mySingleton = new MySingleton_Static();

    public MySingleton_Static() {
        System.out.println("Loader");// 监控实例化时机
    }

    public static MySingleton_Static getInstance() {
        return mySingleton;
    }
}

class MySingleton_Static_test {
    public static void main(String[] args) {
        System.out.println("test classLoader ");// test classLoader (并非第一时间初始化对象)
        System.out.println("test classLoader " + MySingleton_Static.initInstall);// Loader > test classLoader 1
//        System.out.println("test classLoader " + MySingleton_Static.getInstance());// [Loader] > test classLoader **@14ae5a5
    }
}

/* 静态内部类(避免static变量访问static{}执行间接的对象初始化) */
class Singleton {
    private Singleton() {
        System.out.println("Loader");// 监控实例化时机
    }

    // 注意：static属性不是对象信息,而是在`方法区-运行时常量池`中。与类对象无关(同理类的序列化也不包含static属性)
    public static int initInstall = 1;// 避免访问static触发类的初始化(仅能通过getInstance方法初始化)

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

class Singleton_test {
    public static void main(String[] args) {
        System.out.println("test classLoader ");// test classLoader (此时还没有初始化,如上文是合理的)
        System.out.println("test classLoader " + Singleton.initInstall);// test classLoader 1 (没有触发类的初始化,因为没有new)
        System.out.println("test classLoader " + Singleton.getInstance());// Loader > test classLoader **@14ae5a5
    }
}