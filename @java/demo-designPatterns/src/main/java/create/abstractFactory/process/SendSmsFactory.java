package create.abstractFactory.process;


import create.abstractFactory.material.Sender;
import create.abstractFactory.material.SmsSender;

public class SendSmsFactory implements Provider
{

	@Override
	public Sender produce()
	{
		return new SmsSender();
	}
}