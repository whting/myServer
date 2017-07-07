package create.singleton.process.liuxiang;

import java.io.Serializable;

/* 仅体现单例思想,无法防御多线程 */
class MySingleton {
    private static MySingleton mySingleton;

    private MySingleton() {
    }

    private static MySingleton getInstance() {
        if (mySingleton != null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}

/* doubleCheck&volatile（防御：多线程访问/内存优化排序） */
class MySingleton_Thread implements Serializable {

    private static volatile MySingleton_Thread mySingleton = null;// volatile 内存有序和原子可见

    private MySingleton_Thread() {
    }

    private static MySingleton_Thread getInstance() {
        if (mySingleton == null) {// 避免已经实例化后方法调用,无需在synchronized上耗费资源
            synchronized (MySingleton_Thread.class) {
                if (mySingleton == null) {// 避免内存排序,结合volatitle最终判断对象初始化状态
                    mySingleton = new MySingleton_Thread();
                }
            }
        }
        return mySingleton;
    }

    /**
     * readResolve方法应对单例对象被序列化时候
     */
    private Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) {
        System.out.println("test classLoader " + mySingleton);// test classLoader null
        System.out.println("test classLoader " + getInstance());// test classLoader create.singleton.process.MySingleton_Thread@73a28541
    }
}

/**
 * 枚举
 * 功能上与共有域方法相近，但是它更简洁，无偿地提供了序列化机制，绝对防止对此实例化，即使是在面对复杂的序列化或者反射攻击的时候。
 * 虽然这中方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
 * */
enum Singleton_enum {
    INSTANCE;

    public String getInfo(String s) {
        s = "hello " + s;
        return s;
    }

    public static void main(String[] args) {
        String s = INSTANCE.getInfo("aa");
        System.out.println(s);
    }
}

/**
 * 多线程并发下的单例模式 - 简书
 * http://www.jianshu.com/p/75b461f3bfa6
 *
 * 单例模式、双检测锁定DCL、volatile详解 - 推酷
 * http://www.tuicool.com/articles/vIB3Un
 *
 * Java实现单例的难点 - 推酷
 * http://www.tuicool.com/articles/U7F7fii
 */

