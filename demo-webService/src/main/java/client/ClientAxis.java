package client;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class ClientAxis {
    public static void main(String[] args) throws ServiceException {
        System.out.println("begin...");
        client.HelloWorldServiceLocator helloWorldServiceLocator = new client.HelloWorldServiceLocator();
        client.HelloWorld_PortType helloWorld_portType = helloWorldServiceLocator.getHelloWorld();
        try {
            String result = helloWorld_portType.sayHello("heihei");
            System.out.println("result:" + result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
