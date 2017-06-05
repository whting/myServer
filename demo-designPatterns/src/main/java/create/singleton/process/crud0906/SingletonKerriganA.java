package create.singleton.process.crud0906;
/**   
 * 实现单例访问Kerrigan的第一次尝试   
 */    
public class SingletonKerriganA {     
      
    /**   
     * 单例对象实例   
     */    
    private static SingletonKerriganA instance = null;     
      
    public static SingletonKerriganA getInstance() {     
        if (instance == null) {                              //line A     
            instance = new SingletonKerriganA();          //line B     
        }     
        return instance;     
    }     
}     