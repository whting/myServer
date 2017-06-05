package create.factoryMethod.process;

import create.factoryMethod.material.MailSender;
import create.factoryMethod.material.Sender;
import create.factoryMethod.material.SmsSender;

public class SendMethodFactory
{
	public Sender produceMail()
	{
		return new MailSender();
	}

	public Sender produceSms()
	{
		return new SmsSender();
	}
}
