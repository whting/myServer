package create.singleton.process;

import java.util.Vector;

public class SingletonShadow
{
	private static SingletonShadow instance = null;
	private Vector properties = null;

	public Vector getProperties()
	{
		return properties;
	}

	private SingletonShadow()
	{}

	private static synchronized void syncInit()
	{
		if (instance == null)
		{
			instance = new SingletonShadow();
		}
	}

	public static SingletonShadow getInstance()
	{
		if (instance == null)
		{
			syncInit();
		}
		return instance;
	}

	public void updateProperties()
	{
		SingletonShadow shadow = new SingletonShadow();
		properties = shadow.getProperties();
	}
}
