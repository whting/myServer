package java8.twoColons;

class TwoColonsUtil {

	public static <T> String getSomethingObj(T a, T b) {
		// 更多的可以考虑入参的类型,进行处理的区分
		return a + ";" + b;
	}

	public static String getSomething(String a, String b) {
		return a + ";" + b;
	}

	public String doGet(String a, String b) {
		return a + ";" + b;
	}

	public static void main(String[] args) {

		// lambda 实现
		FuncI f0 = (a, b) -> a + ";" + b;
		System.out.println(f0.get("aaa", "bbb"));

		/**
		 * @我的理解:依据函数接口`FuncI`的定义 ,进行匿名函数实现的封装
		 * @获取方法的实现: TwoColonsUtil.getSomething(String a,String b)
		 * @等同于:(String a,String b) -> a + ";" + b
		 * @再使用快捷调用:TwoColonsUtil::getSomething 完成响应
		 * @getSomething == (a,b) -> a + ";" + b
		 * @TwoColonsUtil:: 只是为了找到getSomething
		 */
		FuncI f = TwoColonsUtil::getSomething;
		System.out.println(f.get("aaa", "bbb"));

		/** 封装后可供不同的@FunctionInterface所使用 */
		FuncI f1 = TwoColonsUtil::getSomethingObj;
		System.out.println(f.get("aaa", "bbb"));

		FuncI2 f2 = TwoColonsUtil::getSomethingObj;
		System.out.println(f.get("aaa", "bbb"));

		// `TwoColonsUtil::getSomething`对应对象
		System.out.println(((FuncI) TwoColonsUtil::getSomething).get("aaa", "bbb"));

		// 非静态
		FuncI ff = new TwoColonsUtil()::doGet;
		System.out.println(ff.get("ccc", "ddd"));
		System.out.println(((FuncI) new TwoColonsUtil()::doGet).get("ccc", "ddd"));
	}
}

@FunctionalInterface
interface FuncI {
	public String get(String a, String b);
}

@FunctionalInterface
interface FuncI2 {
	public String get(int a, int b);
}