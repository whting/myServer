package behavior.Interpreter.client;

import behavior.Interpreter.material.Context;
import behavior.Interpreter.material.Minus;
import behavior.Interpreter.material.Plus;

public class Client
{

	public static void main(String[] args)
	{
		// 计算9+2-8的值
		int result = new Minus().interpret( // Minus 减法,计算
				(new Context(new Plus().interpret( // Plus 加法,计算
						new Context(9, 2)), 8)));
		System.out.println(result);
	}
}