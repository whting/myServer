
public class MyDescriptionHandle {

    @MyDescription(entity="user",params = {"name","age"})// 参数列表含义对照
    public void handle(String name,int age) {
        System.out.println("Handle finish");
    }
}
