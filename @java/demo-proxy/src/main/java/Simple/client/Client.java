package Simple.client;

import Simple.material.Count;
import Simple.material.CountImpl;
import Simple.process.CountProxy;
import Simple.process.MyInvocationHandler;

/** 测试Count类
 * 
 * @author Administrator */
public class Client
{
	public static void main(String[] args) throws Throwable {
		CountImpl countImpl = new CountImpl();
		// 方法覆盖代理
		Count countProxy = new CountProxy(countImpl);
		countProxy.updateCount();
		countProxy.queryCount();

		// 通用方法代理
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		Count countProxy2 = (Count)myInvocationHandler.bind(countImpl);
		countProxy2.updateCount();
		countProxy2.queryCount();
	}
}