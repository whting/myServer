package app1_rmi;

import app1_rmi.process.JmiDemoBeanImpl;
import app1_rmi.process.JmiDemoBean;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class JmiDemoSer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 创建一个远程对象  
            JmiDemoBean jmiImpl = new JmiDemoBeanImpl();
            // 本地主机上的远程对象注册表Registry的实例，并指定端口为8888，缺少注册表创建，则无法绑定对象到远程注册表上  
            LocateRegistry.createRegistry(8888);
            // 把远程对象注册到RMI注册服务器上，并命名为jmiImpl  
            Naming.bind("rmi://localhost:8888/RHello", jmiImpl);
            System.out.println("远程IHello对象绑定成功！");
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (java.rmi.AlreadyBoundException e) {
            System.out.println("发生重复绑定对象异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }

    }
}  