package structure.bridge.process;

import structure.bridge.material.Sourceable;

public class Bridge
//public abstract class Bridge
{
	private Sourceable source;

	public void method()
	{
		source.method();
	}

	public Sourceable getSource()
	{
		return source;
	}

	public void setSource(Sourceable source)
	{
		this.source = source;
	}
}