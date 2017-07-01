package structure.bridge.client;

import structure.bridge.material.SourceSub1;
import structure.bridge.material.SourceSub2;
import structure.bridge.material.Sourceable;
import structure.bridge.process.Bridge;
import structure.bridge.process.MyBridge;

public class Client
{

	public static void main(String[] args)
	{

		Bridge bridge = new MyBridge();

		/* 调用第一个对象 */
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();

		/* 调用第二个对象 */
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}