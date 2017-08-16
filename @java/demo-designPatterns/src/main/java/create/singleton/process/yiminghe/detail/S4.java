package create.singleton.process.yiminghe.detail;
class S4 {  
    private S4() {  
        System.out.println("ok4");  
    }  
  
    private static class S4Holder {  
        static S4 instance = new S4();  
    }  
  
  
    public static S4 getInstance() {  
        return S4Holder.instance;  
    }  
}  