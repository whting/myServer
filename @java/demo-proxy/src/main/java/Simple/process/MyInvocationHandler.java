package Simple.process;

import java.lang.reflect.Method;

public class MyInvocationHandler {

    private Object target;

    public Object bind(Object proxy) {
        this.target = target;
        return new CountProxy2(this,proxy);// 动态代理,则'CountProxy2'类是依据待代理类自动生成
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事物开始");
        result = method.invoke(proxy, args);// 执行方法
        System.out.println("事物结束");
        return result;
    }
}
