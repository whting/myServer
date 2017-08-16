package create.factoryMethod.process;

import create.factoryMethod.material.MailSender;
import create.factoryMethod.material.Sender;
import create.factoryMethod.material.SmsSender;

public class SendStaticFactory
{
	public static Sender produceMail()
	{
		return new MailSender();
	}

	public static Sender produceSms()
	{
		return new SmsSender();
	}
}
