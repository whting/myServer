package app1_rmi.process;

import java.rmi.Remote;
import java.rmi.RemoteException;  
  
public interface JmiDemoBean extends Remote {  
    public String sayHello() throws RemoteException;  
}  