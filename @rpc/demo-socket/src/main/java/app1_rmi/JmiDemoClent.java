package app1_rmi;

import app1_rmi.process.JmiDemoBean;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class JmiDemoClent {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 在RMI服务注册表中查找名称为JmiDemoBean的对象，并调用其上的方法  
            JmiDemoBean jBean = (JmiDemoBean) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(jBean.sayHello());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}  