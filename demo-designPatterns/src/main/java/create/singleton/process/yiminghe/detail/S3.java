package create.singleton.process.yiminghe.detail;
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