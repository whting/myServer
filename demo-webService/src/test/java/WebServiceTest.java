import javax.xml.ws.Endpoint;

public class WebServiceTest {
    public static void main(String args[]){
        Object hello = new HelloWorld();
        String address = "http://localhost:8989/sayHello";// 发布到的地址
        Endpoint.publish(address, hello);
        System.out.println("发布成功");
    }
}
