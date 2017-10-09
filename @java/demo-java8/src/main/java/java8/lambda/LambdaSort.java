package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaSort {
	public static void main(String[] args) {
		String[] array = { "bbb", "ddd", "aaa" };

		// java 6
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(Arrays.asList(array));

		// java 8 Lambda Array Sort
		String[] array2 = { "bbb", "ddd", "aaa" };
		Arrays.sort(array2, (String a, String b) -> a.compareTo(b));
		System.out.println(Arrays.asList(array2));

		// java 8 Lambda List Sort
		List<String> list = Arrays.asList("bbb", "ddd", "aaa");
		list.sort((String a, String b) -> a.compareTo(b));// list.sort() 仅1.8 才提供,早期没有
		System.out.println(list);
	}
}
