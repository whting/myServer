package create.abstractFactory.client;

import create.abstractFactory.material.Sender;
import create.abstractFactory.process.Provider;
import create.abstractFactory.process.SendMailFactory;

public class Client
{
	public static void main(String[] args)
	{
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}
