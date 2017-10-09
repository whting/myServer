package create.singleton.process.crud0906;

public class Singleton {

	// DCL双锁检测（double checked locking）模式,配合volatile来保证并发的原子对象读取
	private volatile static Singleton singleton;

	private Singleton() {
	};

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}