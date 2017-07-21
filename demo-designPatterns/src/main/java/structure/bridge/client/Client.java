package structure.bridge.client;

import structure.bridge.material.SourceSub1;
import structure.bridge.material.SourceSub2;
import structure.bridge.material.Sourceable;
import structure.bridge.process.Bridge;

public class Client {

    public static void main(String[] args) {

        Bridge bridge = new Bridge();
//        Bridge bridge = new MyBridge();

		/* 调用第一个对象 */
        Sourceable source1 = new SourceSub1();
        source1.method();// 直接调用(业务的控制要化实例前)

		/* 调用第二个对象 */
        Sourceable source2 = new SourceSub2();
        source2.method();// 直接调用(业务的控制要化实例前)

		/* 桥接调用:面向bridge的方式,由业务决定使用哪方来处理具体的实例(例如:jdbc)
		 * 可对已经实例化的对象进行动态桥接 **/
        if (true) {
            bridge.setSource(source1);// 例:mysql
        } else {
            bridge.setSource(source2);// 例:oracle
        }
        bridge.method();
    }
}