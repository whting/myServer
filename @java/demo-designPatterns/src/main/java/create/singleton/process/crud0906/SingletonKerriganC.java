package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第三次尝试   
 */    
public class SingletonKerriganC {     
      
    /**   
     * 单例对象实例   
     */    
    private static SingletonKerriganC instance = null;     
      
    public static SingletonKerriganC getInstance() {     
        synchronized (SingletonKerriganC.class) {     
            if (instance == null) {     
                instance = new SingletonKerriganC();     
            }     
        }     
        return instance;     
    }     
}   