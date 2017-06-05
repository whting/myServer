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
    Ԥ�ȼ��ط� 
    �ŵ㣺1.�̰߳�ȫ��, 
          2.������ص�ͬʱ�Ѿ�������һ����̬����,����ʱ��Ӧ�ٶȿ졣 
 
    ȱ�㣺 ��Դ����Ч�ʲ��ߣ������������������Ҫʹ��Ҳ��ϵͳ���� 
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
    initialization on demand,�ӳټ��ط�  (���Ƕ��߳�) 
    �ŵ㣺1.��Դ�����ʸ� 
    ȱ�㣺��һ�μ����Ƿ�Ӧ����  �����߳�ʹ�ò���Ҫ��ͬ�������� 
 
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
    initialization on demand - double check �ӳټ��ط��Ľ�֮˫�ؼ��  (���Ƕ��߳�) 
    �ŵ㣺1.��Դ�����ʸ� 
    ȱ�㣺��һ�μ����Ƿ�Ӧ����  ������java �ڴ�ģ��һЩԭ��ż����ʧ�� 
 
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
   initialization on demand holder  (���Ƕ��߳�) 
   �ŵ㣺1.��Դ�����ʸ� 
   ȱ�㣺��һ�μ����Ƿ�Ӧ���� 
 
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