package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第五次尝试   
 */    
public class SingletonKerriganE {     
      
    /**   
     * 单例对象实例   
     */    
    private static SingletonKerriganE instance = new SingletonKerriganE();     
      
    public static SingletonKerriganE getInstance() {     
        return instance;     
    }     
}    