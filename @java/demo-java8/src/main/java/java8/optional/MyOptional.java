package java8.optional;

import java.util.Optional;

public class MyOptional {

	public static void optional() {
		Optional<String> optional = Optional.of("bam");

		optional.isPresent(); // true
		optional.get(); // "bam"
		optional.orElse("fallback");// "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));// "b"
	}

	public static void optionalMore() {
		String str = "aaa";

		Optional<String> optional_2 = Optional.of(str); // 如果str ==
		// null，抛出错误NullPointerException
		Optional<String> optional = Optional.ofNullable(str); // 如果str ==
		// null，返回一个空Optional<String>
		Optional.<String> empty(); // 返回一个空Optional<String>

		String s = optional.get(); // 获取被包装的值
		optional.ifPresent((value) -> System.out.println("hello " + value)); // 如果optional的value不是null，则执行函数表达式

		optional.orElse("elseValue"); // 如果optional的value为null，则返回"elseValue"
		optional.orElseGet(() -> "orElseGet"); // 如果optional的value不是null，则返回函数表达式的执行结果
		optional.orElseThrow(RuntimeException::new); // 如果optional的value不是null，则抛出错误

		optional.filter((value) -> value.length() == 5); // 过滤得到长度等于5的value

		optional.map((value) -> {
			System.out.println("map:" + value);
			return value;
		});

		optional.flatMap((value) -> {
			System.out.println("flatMap:" + value);
			return Optional.ofNullable(value);
		});

		// map 与 flatMap 区别
		Optional<String> os = Optional.of("bbb");
		os.map((value) -> Optional.of(value)); // 返回的类型是Optional<Optional<String>>
		os.flatMap((value) -> Optional.of(value)); // 返回的类型是Optional<String>
	}

	public static void main(String[] args) {
		optional();
		optionalMore();
	}
}
/**
 * Optionals(可选项)
 *
 * @Optionals是没有函数的接口，取而代之的是防止 NullPointerException
 *                             异常。这是下一节的一个重要概念，所以让我们看看如何结合Optionals工作。
 *
 * @Optional is a simple container for a value which may be null or non-null.
 *           Think of a method which may return a non-null result but sometimes
 *           return nothing. Instead of returning null you return an Optional in
 *           Java 8.
 *
 * @Optional是一个简单的容器，这个值可能是空的或者非空的。考虑到一个方法可能会返回一个non-null的值， 也可能返回一个空值。
 *                                                           为了不直接返回null，我们在Java
 *                                                           8中就返回一个Optional。
 *
 *
 * @http://www.tuicool.com/articles/RjqEJrm
 **/


