package java8.functionalInterface;

public class Func implements FuncI{

	public String builder(String first, String last)
	{
		return first + "." + last;
	}

	public static void main(String[] args) {

		// java 6,7
		FuncI func = new Func();
		System.out.println(func.builder("f", "l"));

		// java 6,7 匿名
		func = new FuncI(){
			public String builder(String first, String last) {
				return first + "." + last;
			}
		};
		System.out.println(func.builder("f", "l"));

		// java 8
		func = (String first, String last) -> {
			return first + "." + last;
		};
		System.out.println(func.builder("f", "l"));

		/**
		 * @我的理解:依据函数接口`FuncI`的定义
		 * @指明定义(String first, String last)
		 * @使用快捷实现(匿名实现): [-> first + "." + last],同时调用,响应
		 * @像匿名函數(方法),最终的响应对象是FuncI(@FunctionalInterface)
		 */
		func = (String first, String last) -> first + "." + last;
		System.out.println(func.builder("f", "l"));

		func = (first,last) -> first + "." + last;
		System.out.println(func.builder("f", "l"));

		// 关系对应 FuncI <-> (String first, String last) -> first + "." + last | FuncI对象的具体匿名实现
		System.out.println(((FuncI)(first,last) -> first + "." + last).builder("f", "l"));
	}

}

@FunctionalInterface
interface FuncI {
	String builder(String firstName, String lastName);

	/**
	 * @错误提示
	 * <pre>
	 * Invalid '@FunctionalInterface' annotation; FuncI is not a functional interface
	 * 无效的@FunctionalInterface注释;FuncI不是一个功能接口
	 * </pre>
	 */
	// String builder2(String firstName, String lastName);
}