package behavior.templateMethod.client;

import behavior.templateMethod.material.Plus;
import behavior.templateMethod.process.AbstractCalculator;

public class Client
{
	public static void main(String[] args)
	{
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println(result);
	}
}