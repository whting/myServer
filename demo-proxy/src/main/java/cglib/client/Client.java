package cglib.client;

import cglib.material.BookFacadeImpl;
import cglib.process.BookFacadeCglib;


public class Client
{

	public static void main(String[] args)
	{
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
		bookCglib.addBook();
	}
}