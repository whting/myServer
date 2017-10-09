package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第四次尝试   
 */    
public class SingletonKerriganD {     
      
    /**   
     * 单例对象实例   
     */    
    private static SingletonKerriganD instance = null;     
      
    public static SingletonKerriganD getInstance() {     
        if (instance == null) {     
            synchronized (SingletonKerriganD.class) {     
                if (instance == null) {     
                    instance = new SingletonKerriganD();     
                }     
            }     
        }     
        return instance;     
    }     
}    