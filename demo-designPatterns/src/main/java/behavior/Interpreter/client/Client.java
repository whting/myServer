package behavior.Interpreter.client;

import behavior.Interpreter.material.Context;
import behavior.Interpreter.material.Minus;
import behavior.Interpreter.material.Plus;

public class Client
{

	public static void main(String[] args)
	{
		// ����9+2-8��ֵ
		int result = new Minus().interpret( // Minus ����,����
				(new Context(new Plus().interpret( // Plus �ӷ�,����
						new Context(9, 2)), 8)));
		System.out.println(result);
	}
}