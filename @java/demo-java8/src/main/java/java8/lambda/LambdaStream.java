package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaStream {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "abb", "ddd");

		// 逻辑过虑
		List<String> listTemp = new ArrayList<String>();
		list.forEach((item) -> {
			if (item.startsWith("a"))
				listTemp.add(item);
		});
		listTemp.forEach(System.out::println);

		System.out.println("---");

		/** stream().filter 过虑函数-内容 */
		// Predicate == (String item) -> {return item.startsWith("a");}  == (item) -> item.startsWith("a")
		list.stream().filter((item) -> item.startsWith("a"))// filter是接口,具体的时间是ReferencePipeline.filter
				.forEach(System.out::println);// Stream.forEach()

		System.out.println("---");

		// stream().filter 过虑函数-范围
		list = Arrays.asList("abc", "abb", "ddd", "111", "ddd", "yyy", "999");
		list.stream().limit(4).forEach(System.out::println);

	}
}
