package jdk.client;

import jdk.material.BookFacade;
import jdk.material.BookFacadeImpl;
import jdk.process.BookFacadeProxy;


public class Client
{

	public static void main(String[] args)
	{
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
		bookProxy.addBook();
	}

}