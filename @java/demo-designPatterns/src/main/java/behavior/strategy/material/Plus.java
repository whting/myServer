package behavior.strategy.material;

import behavior.strategy.process.AbstractCalculator;

public class Plus extends AbstractCalculator implements ICalculator
{

	@Override
	public int calculate(String exp)
	{
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}
}