package create.factoryMethod.process;

import create.factoryMethod.material.MailSender;
import create.factoryMethod.material.Sender;
import create.factoryMethod.material.SmsSender;

public class SendFactory
{
	public Sender produce(String type)
	{
		if ("mail".equals(type))
		{
			return new MailSender();
		} else if ("sms".equals(type))
		{
			return new SmsSender();
		} else
		{
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
}
