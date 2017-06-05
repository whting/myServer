package doings.iterator.client;

import doings.iterator.material.Collection;
import doings.iterator.material.Iterator;
import doings.iterator.material.MyCollection;

public class Client
{

	public static void main(String[] args)
	{
		Collection collection = new MyCollection();
		Iterator it = collection.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}