package behavior.Command.client;

import behavior.Command.material.Command;
import behavior.Command.material.Invoker;
import behavior.Command.material.MyCommand;
import behavior.Command.material.Receiver;

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