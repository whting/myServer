package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaForEach {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");

		// java 6,7
		for (String item : list) {
			System.out.println(item);
		}

		// java 6,7 匿名
		list.forEach(new Consumer<String>() {
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// java 8 Lambda 语法
		list.forEach((item) -> System.out.println(item));

		/**
		 * @解析
		 * @default void forEach(Consumer<? super T> action)
		 *
		 * @Consumer 定义:
		 *
		 *           <pre>
		 * &#64;FunctionalInterface
		 * public interface Consumer<T>
		 * void accept(T t);
		 *           </pre>
		 *
		 * @开始解剖:
		 * @1.forEach如参为Consumer
		 * @2.Consumer的函数接口定义为accept(T t)
		 * @3.System .out::println对应Consumer.accept(T t)的封装实现为
		 *
		 *           <pre>
		 *           public void println(String x) {
		 *           	synchronized (this) {
		 *           		print(x);
		 *           		newLine();
		 *           	}
		 *           }
		 *           </pre>
		 *
		 * @4.等同于
		 *
		 * 		<pre>
		 *        list.forEach((x) -> {
		 *        	synchronized (LambdaForEach.class) {
		 *        		System.out.println(x);
		 *        	}
		 *        });
		 *        </pre>
		 */

		// `java 8 Lambda 更简` 的翻译表达
		list.forEach((x) -> {
			synchronized (LambdaForEach.class) {
				System.out.println(x);
			}
		});

		// java 8 Lambda 更简洁
		list.forEach(System.out::println);


		// 其它,return 数组
		System.out.println(list);
	}
}
