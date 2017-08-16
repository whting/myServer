package structure.adapter.process;

import structure.adapter.material.Source;
import structure.adapter.material.Targetable;

public class Adapter extends Source implements Targetable
{

	@Override
	public void method2()
	{
		System.out.println("this is the targetable method!");
	}
}