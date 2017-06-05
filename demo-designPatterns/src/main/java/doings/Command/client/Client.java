package doings.Command.client;

import doings.Command.material.Command;
import doings.Command.material.Invoker;
import doings.Command.material.MyCommand;
import doings.Command.material.Receiver;

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