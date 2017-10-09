package Simple.process;

import Simple.material.Count;

public class CountProxy2 implements Count {

    MyInvocationHandler myInvocationHandler;
    Object proxy;

    /**
     * 覆盖默认构造器
     *
     * @param
     */
    public CountProxy2(MyInvocationHandler myInvocationHandler,Object proxy) {
        this.myInvocationHandler = myInvocationHandler;
        this.proxy = proxy;
    }

    @Override
    public void queryCount() throws Throwable {
        myInvocationHandler.invoke(proxy,proxy.getClass().getMethod("queryCount"),null);
    }

    @Override
    public void updateCount()throws Throwable {
        myInvocationHandler.invoke(proxy,proxy.getClass().getMethod("updateCount"),null);
    }

}