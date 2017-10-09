package structure.adapter.client;

import structure.adapter.material.Source;
import structure.adapter.material.Targetable;
import structure.adapter.material2.SourceSub1;
import structure.adapter.material2.SourceSub2;
import structure.adapter.material2.Sourceable;
import structure.adapter.process.Adapter;
import structure.adapter.process.Wrapper;

public class Client {
    public static void main(String[] args) {

        // 对象适配模式
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();

        // 类的适配器模式
        Targetable target2 = new Adapter();
        target2.method1();
        target2.method2();

        System.out.println();

        // 接口的适配器模式
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
