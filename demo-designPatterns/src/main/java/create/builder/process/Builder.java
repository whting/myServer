package create.builder.process;

import java.util.ArrayList;
import java.util.List;

import create.builder.material.MailSender;
import create.builder.material.Sender;
import create.builder.material.SmsSender;

public class Builder
{

	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new SmsSender());
		}
	}

	public List<Sender> getList()
	{
		return list;
	}
}