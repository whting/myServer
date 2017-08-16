package behavior.iterator.client;

import behavior.iterator.material.Collection;
import behavior.iterator.material.Iterator;
import behavior.iterator.material.MyCollection;

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