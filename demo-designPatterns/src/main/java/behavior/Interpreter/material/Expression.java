package behavior.Interpreter.material;

public interface Expression
{
	/** 解读 or 计算
	 *
	 * @param context
	 * @return */
	public int interpret(Context context);
}