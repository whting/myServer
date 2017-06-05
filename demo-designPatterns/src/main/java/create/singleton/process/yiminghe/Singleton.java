package create.singleton.process.yiminghe;
/** 
 * Created by IntelliJ IDEA. 
 * User: yiminghe 
 * Date: 2009-6-8 
 * Time: 19:20:52 
 */  
public class Singleton {  
    public static void main(String[] args) throws Exception{  
        System.out.println(Class.forName("S1"));  
        System.out.println(Class.forName("S2"));  
        System.out.println(Class.forName("S3"));  
        System.out.println(Class.forName("S4"));  
    }  
}  
  
/* 
    预先加载法 
    优点：1.线程安全的, 
          2.在类加载的同时已经创建好一个静态对象,调用时反应速度快。 
 
    缺点： 资源利用效率不高，可能这个单例不会需要使用也被系统加载 
 */  
class S1 {  
    private S1() {  
        System.out.println("ok1");  
    }  
  
  
    private static S1 instance = new S1();  
  
    public static S1 getInstance() {  
        return instance;  
    }  
}  
  
/* 
    initialization on demand,延迟加载法  (考虑多线程) 
    优点：1.资源利用率高 
    缺点：第一次加载是发应不快  ，多线程使用不必要的同步开销大 
 
 */  
class S2 {  
    private S2() {  
        System.out.println("ok2");  
    }  
  
    private static S2 instance = null;  
  
    public static synchronized S2 getInstance() {  
        if (instance == null) instance = new S2();  
        return instance;  
    }  
}  
  
  
/* 
    initialization on demand - double check 延迟加载法改进之双重检测  (考虑多线程) 
    优点：1.资源利用率高 
    缺点：第一次加载是发应不快  ，由于java 内存模型一些原因偶尔会失败 
 
 */  
class S3 {  
    private S3() {  
        System.out.println("ok3");  
    }  
  
    private static S3 instance = null;  
  
    public static S3 getInstance() {  
        if (instance == null) {  
            synchronized (S3.class) {  
                if (instance == null)  
                    instance = new S3();  
            }  
        }  
        return instance;  
    }  
}  
  
  
/* 
   initialization on demand holder  (考虑多线程) 
   优点：1.资源利用率高 
   缺点：第一次加载是发应不快 
 
*/  
class S4 {  
    private S4() {  
        System.out.println("ok4");  
    }  
  
    private static class S4Holder {  
        static S4 instance = new S4();  
    }  
  
  
    public static S4 getInstance() {  
        return S4Holder.instance;  
    }  
}  