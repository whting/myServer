package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第二次尝试   
 */    
public class SingletonKerriganB {     
      
    /**   
     * 单例对象实例   
     */    
    private static SingletonKerriganB instance = null;     
      
    public synchronized static SingletonKerriganB getInstance() {     
        if (instance == null) {     
            instance = new SingletonKerriganB();     
        }     
        return instance;     
    }     
}  