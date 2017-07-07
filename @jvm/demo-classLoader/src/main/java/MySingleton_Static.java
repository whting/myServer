class MySingleton_Static {

    // 初始化时机：当任意static被被访问时,会初始化实例(建议initInstall)。否则将在getInstall访问时才创建(非饿加载)
    public static int initInstall = 1;

    /* 考虑类加载机制的初始化条件(被new或内部static被访问),所以启动时并不会实例化*/
    private static MySingleton_Static mySingleton = new MySingleton_Static();

    private MySingleton_Static() {
        System.out.println("Loader");// 监控实例化时机
    }

    public static MySingleton_Static getInstance() {
        return mySingleton;
    }
}

class MySingleton_Static_test {
    public static void main(String[] args) {
        System.out.println("test classLoader ");// test classLoader null
        System.out.println("test classLoader " + MySingleton_Static.initInstall);// Loader > test classLoader 1
        System.out.println("test classLoader " + MySingleton_Static.getInstance());// [Loader] > test classLoader **@14ae5a5
    }
}
