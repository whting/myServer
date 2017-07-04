package behavior.Command.client;

import behavior.Command.material.Command;
import behavior.Command.material.Invoker;
import behavior.Command.material.MyCommand;
import behavior.Command.material.Receiver;

public class Client
{

	public static void main(String[] args)
	{
		Receiver receiver = new Receiver();// �����ߣ�ʿ����
		Command cmd = new MyCommand(receiver);// MyCommand������
		Invoker invoker = new Invoker(cmd);// �����ߣ�˾��Ա��
		invoker.action();
	}
}