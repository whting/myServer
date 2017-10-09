package reflect.material2;

import java.lang.reflect.Method;

public class InvokeTester {
    
    public int add(int param1,int param2)
    {
        return param1 + param2;
    }
    
    public String echo(String message){
        return "hello" + message;
    }
    
    public static void main(String[] args) throws Exception{
        Class<?> classType = InvokeTester.class;//获取类对象
        
        Object invokeTester = classType.newInstance();//获取类对象的实例
        
        Method addMethod = classType.getMethod("add", new Class[]{int.class,int.class});//获取add方法
        
        Object result = addMethod.invoke(invokeTester, new Object[]{1,2});//调用
        
        System.out.println((Integer)result);//输出：3
        
        Method echpMethod = classType.getMethod("echo", new Class[]{String.class});//获取echo方法
        
        Object result2 = echpMethod.invoke(invokeTester, new Object[]{"tom"});//调用
        
        System.out.println((String)result2);//输出：hellotom
    }
}