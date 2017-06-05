package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第六次尝试   
 */    
public class SingletonKerriganF {     
      
    private static class SingletonHolder {     
        /**   
         * 单例对象实例   
         */    
        static final SingletonKerriganF INSTANCE = new SingletonKerriganF();     
    }     
      
    public static SingletonKerriganF getInstance() {     
        return SingletonHolder.INSTANCE;     
    }     
}    