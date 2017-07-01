package structure.decorator.client;

import structure.decorator.material.Source;
import structure.decorator.material.Sourceable;
import structure.decorator.process.Decorator;

public class Client
{

	public static void main(String[] args)
	{
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}