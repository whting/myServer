package behavior.state.client;

import behavior.state.material.Context;
import behavior.state.material.State;

public class Client
{

	public static void main(String[] args)
	{
		State state = new State();
		Context context = new Context(state);

		// 设置第一种状态
		state.setValue("state1");
		context.method();

		// 设置第二种状态
		state.setValue("state2");
		context.method();
	}
}