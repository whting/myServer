package java8.lambda;

public class LambdaThread {

	public static void main(String[] args) {

		// 1.继承Thread类
		new hello("A").start();
		new hello("B").start();

		// 2.实现Runnable接口
		new Thread(){
			@Override
			public void run() {
				System.out.println("~");
			}
		}.start();

		new Thread(new helloR("线程A")).start();
		new Thread(new helloR("线程B")).start();

		// 3.匿名接口
		String name = "匿名接口线程";
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(name + "运行     " + i);
				}
			}
		}).start();

		// 4.Lambda
		Runnable runnable = () -> System.out.println("hello thread");
		new Thread(runnable).start();

		// 5.Lambda 匿名使用
		new Thread(() -> System.out.println("hello thread")).start();

		/***
		 * 关键在于Runnable对象支持了函数接口`@FunctionalInterface`
		 *
		 * @()无参是与`public abstract void run();`对应,所以无参数
		 * @逻辑:() -> System.out.println("hello thread")为Runnable.run()函数的匿名实现
		 *
		 */

		// 6.Lambda TwoColons 实现(即把函数的密名实现,封装了一层.方便调用且方便复用)
		new Thread(LambdaThreadTwoColons::run).start();

		// 7.myRunabele New TwoColons 实现
		new Thread(myRunabele::new).start();
	}
}

/**
 * @author Rollen-Holt 继承Thread类,直接调用run方法
 */
class hello extends Thread {

	private String name;

	public hello() {

	}

	public hello(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行     " + i);
		}
	}

	// public static void main(String[] args) {
	// hello h1 = new hello("A");
	// hello h2 = new hello("B");
	// h1.run();
	// h2.run();
	// }
}

/**
 * @author Rollen-Holt 实现Runnable接口
 */
class helloR implements Runnable {

	public helloR() {

	}

	public helloR(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行     " + i);
		}
	}

	// public static void main(String[] args) {
	// helloR h1=new helloR("线程A");
	// Thread demo= new Thread(h1);
	// helloR h2=new helloR("线程Ｂ");
	// Thread demo1=new Thread(h2);
	// demo.start();
	// demo1.start();
	// }

	private String name;
}

/**
 * LambdaThread TwoColons realize
 *
 * @author liuxiang@wosaitech.com
 * @creation 2015年12月7日
 */
class LambdaThreadTwoColons {
	public static void run() {
		System.out.println("Lambda Thread TwoColons realize");
	}
}

/**
 * myRunabele New TwoColons realize
 *
 * @author liuxiang@wosaitech.com
 * @creation 2015年12月7日
 */
class myRunabele {
	public myRunabele() {
		System.out.println("myRunabele TwoColons realize");
	}
}
