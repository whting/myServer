package create.builder.client;

import create.builder.material.Sender;
import create.builder.process.Builder;

import java.util.List;

public class Client
{
	public static void main(String[] args)
	{
		Builder builder = new Builder();
		builder.produceMailSender(10);
		
		List<Sender> list = builder.getList();
		for (Sender sender : list){
			sender.Send();
		}
		
	}
}
