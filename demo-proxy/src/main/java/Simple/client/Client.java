package Simple.client;

import Simple.material.CountImpl;
import Simple.process.CountProxy;

/** 测试Count类
 * 
 * @author Administrator */
public class Client
{
	public static void main(String[] args)
	{
		CountImpl countImpl = new CountImpl();
		CountProxy countProxy = new CountProxy(countImpl);
		countProxy.updateCount();
		countProxy.queryCount();

	}
}