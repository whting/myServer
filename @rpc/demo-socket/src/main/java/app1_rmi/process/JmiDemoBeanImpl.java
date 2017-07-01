package app1_rmi.process;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;  
  
public class JmiDemoBeanImpl extends UnicastRemoteObject implements JmiDemoBean {
        //必须继承UnicastRemoteObject类，不然报错，因为UnicastRemoteObject 实现了底层细节，需要继承  
    // 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，必须声明抛出RemoteException异常  
        public JmiDemoBeanImpl() throws RemoteException {
        super();  
        // TODO Auto-generated constructor stub  
    }  
  
    @Override  
    public String sayHello() throws RemoteException {
        return "你好世界";  
    }  
  
}  