package structure.proxy.process;

import structure.proxy.material.Source;
import structure.proxy.material.Sourceable;

public class Proxy implements Sourceable
{

	private Source source;

	public Proxy()
	{
		super();
		this.source = new Source();
	}

	@Override
	public void method()
	{
		before();
		source.method();
		atfer();
	}

	private void atfer()
	{
		System.out.println("after proxy!");
	}

	private void before()
	{
		System.out.println("before proxy!");
	}
}