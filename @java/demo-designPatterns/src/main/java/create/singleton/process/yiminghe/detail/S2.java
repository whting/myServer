package create.singleton.process.yiminghe.detail;
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