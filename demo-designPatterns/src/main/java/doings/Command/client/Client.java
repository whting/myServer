package doings.Command.client;

import doings.Command.material.Command;
import doings.Command.material.Invoker;
import doings.Command.material.MyCommand;
import doings.Command.material.Receiver;

public class Client
{

	public static void main(String[] args)
	{
		Receiver receiver = new Receiver();// 调用者（士兵）
		Command cmd = new MyCommand(receiver);// MyCommand是命令
		Invoker invoker = new Invoker(cmd);// 调用者（司令员）
		invoker.action();
	}
}