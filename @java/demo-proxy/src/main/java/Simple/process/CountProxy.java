package Simple.process;

import Simple.material.Count;
import Simple.material.CountImpl;

public class CountProxy implements Count
{
	private Count count;

	/** 覆盖默认构造器
	 * 
	 * @param count */
	public CountProxy(CountImpl count)
	{
		this.count = count;
	}

	@Override
	public void queryCount() throws Throwable {
		System.out.println("事务处理之前");
		// 调用委托类的方法;
		count.queryCount();
		System.out.println("事务处理之后");
	}

	@Override
	public void updateCount() throws Throwable {
		System.out.println("事务处理之前");
		// 调用委托类的方法;
		count.updateCount();
		System.out.println("事务处理之后");
	}

}