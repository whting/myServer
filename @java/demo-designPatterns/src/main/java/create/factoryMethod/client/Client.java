package create.factoryMethod.client;

import create.factoryMethod.material.Sender;
import create.factoryMethod.process.SendFactory;
import create.factoryMethod.process.SendMethodFactory;
import create.factoryMethod.process.SendStaticFactory;

public class Client
{
	public static void main(String[] args)
	{
		// 普通工厂
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.Send();

		// 方法工厂
		SendMethodFactory sendMethodFactory = new SendMethodFactory();
		sender = sendMethodFactory.produceMail();
		sender.Send();

		// 静态工厂
		sender = SendStaticFactory.produceMail();
		sender.Send();
	}
}
