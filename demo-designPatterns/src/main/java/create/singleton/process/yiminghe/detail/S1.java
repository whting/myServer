package create.singleton.process.yiminghe.detail;
class S1 {  
    private S1() {  
        System.out.println("ok1");  
    }  
  
  
    private static S1 instance = new S1();  
  
    public static S1 getInstance() {  
        return instance;  
    }  
}  