package create.singleton.process.demo;

public class SingletonDoubleChecked
{

	private static SingletonDoubleChecked instance = null;

	private SingletonDoubleChecked()
	{}

	private static synchronized void syncInit()
	{
		if (instance == null)
		{
			instance = new SingletonDoubleChecked();
		}
	}
	
	// Double-Checked Locking 双重检查锁定模式
	public static SingletonDoubleChecked getInstance()
	{
		if (instance == null)
		{
			syncInit();
		}
		return instance;
	}
}