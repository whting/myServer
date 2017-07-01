import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "http://localhost:9000/HelloWorld")
public class HelloWorld {

    @WebMethod
    public String sayHello(String name) {
        System.out.println(name + ",你好");
        return name + ",你好";
    }

    public static void main(String args[]){
        Object hello = new HelloWorld();
        String address = "http://localhost:9000/HelloWorld";// 发布到的地址
        Endpoint.publish(address, hello);
        System.out.println("发布成功,http://localhost:9000/HelloWorld?wsdl");
    }
}  
