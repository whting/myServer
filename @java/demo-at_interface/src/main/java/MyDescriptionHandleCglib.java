import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.MessageFormat;

public class MyDescriptionHandleCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 代理处理
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        /* 注解识别 */
        if (method.isAnnotationPresent(MyDescription.class)) {
            MyDescription myDescription = method.getAnnotation(MyDescription.class);
            String argEntity = myDescription.entity();
            String[] argParams = myDescription.params();
            String info = MessageFormat.format("注解处理:{0}[{1}({2}),{3}-({4})]"
                    , argEntity, argParams[0], objects[0]
                    , argEntity, argParams[1], objects[1]);
            System.out.println(info);
        }

        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
