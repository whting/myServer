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

		// java6 实现
		FuncI funcI6 = new FuncI() {
			@Override
			public String get(String a, String b) {
				return a + ";" + b;
			}
		};

		System.out.println("java6 "+funcI6.get("aaa", "bbb"));

		// lambda 实现
		FuncI f0 = (a, b) -> a + ";" + b;
		System.out.println("lambda "+f0.get("aaa", "bbb"));

		/**
		 * @我的理解:依据函数接口`FuncI`的定义 ,进行匿名函数实现的封装
		 * @获取方法的实现: TwoColonsUtil.getSomething(String a,String b)
		 * @等同于:(String a,String b) -> a + ";" + b
		 * @再使用快捷调用:TwoColonsUtil::getSomething 完成响应
		 * @getSomething == (a,b) -> a + ";" + b
		 * @TwoColonsUtil:: 只是为了找到getSomething
		 */
		FuncI f = TwoColonsUtil::getSomething;
		System.out.println("::(实现方法提取)-str"+f.get("aaa", "bbb"));

		/** 封装后可供不同的@FunctionInterface所使用 */
		FuncI f1 = TwoColonsUtil::getSomethingObj;
		System.out.println("::(实现方法提取)-obj"+f.get("aaa", "bbb"));

		FuncI2 f2 = TwoColonsUtil::getSomethingObj;
		System.out.println("::(实现方法提取)-obj"+f.get("aaa", "bbb"));

		// `TwoColonsUtil::getSomething`对应对象
		System.out.println("::(实现方法提取)>强转类型"+((FuncI) TwoColonsUtil::getSomething).get("aaa", "bbb"));

		// 非静态
		FuncI ff = new TwoColonsUtil()::doGet;
		System.out.println(ff.get("ccc", "ddd"));
		System.out.println(((FuncI) new TwoColonsUtil()::doGet).get("ccc", "ddd"));
	}
}

@FunctionalInterface
interface FuncI {
	/*(@FunctionalInterface函数接口仅能有一个方法,否则lambda实现时就不能明确实现哪个方法)*/
	public String get(String a, String b);

	/**
	 * java 8 为接口增加了默认函数实体,且不要求继承实现 (此不做演示)
	 *
	 * @param a
	 * @return
	 */
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}

@FunctionalInterface
interface FuncI2 {

	/*(@FunctionalInterface函数接口仅能有一个方法,否则lambda实现时就不能明确实现哪个方法)*/
	public String get(int a, int b);
}