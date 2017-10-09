package structure.proxy.client;

import structure.proxy.material.Sourceable;
import structure.proxy.process.Proxy;

public class Client
{

	public static void main(String[] args)
	{
		Sourceable source = new Proxy();
		source.method();
	}

}