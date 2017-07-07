package create.singleton.process.crud0906;

import java.io.Serializable;

/**   
 * 能应对大多数情况的单例实现   
 */    
public class SingletonKerrigan implements Serializable {     
      
    private static class SingletonHolder {     
        /**   
         * 单例对象实例   
         */    
        static final SingletonKerrigan INSTANCE = new SingletonKerrigan();     
    }     
      
    public static SingletonKerrigan getInstance() {     
        return SingletonHolder.INSTANCE;     
    }     
      
    /**   
     * private的构造函数用于避免外界直接使用new来实例化对象   
     */    
    private SingletonKerrigan() {     
    }
      
    /**   
     * readResolve方法应对单例对象被序列化时候   
     */    
    private Object readResolve() {     
        return getInstance();     
    }     
}   