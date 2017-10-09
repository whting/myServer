package java8.optional;

import java.util.Optional;

public class MyOptionalExample {

	private void nameNotNull() {
		String name = "Tony";
		Optional<String> optName = Optional.of(name);
		System.out.println(optName.get());
	}

	private void nameNull() {
		String name = null;
		Optional<String> optName = Optional.of(name);// of method make NPE Boom
		System.out.println(optName.get());
	}

	private void nameNullable() {
		String name = null;
		Optional<String> optName = Optional.ofNullable(name);
		System.out.println(optName.get());// get method make
		// NoSuchElementException: No value
		// present
	}

	private void nameIsPresent() {
		String name = null;
		Optional<String> optName = Optional.ofNullable(name);
		if (optName.isPresent()) {
			System.out.println(optName.get());
		} else {
			System.out.println("Name is null.");
		}
	}

	private void nameEmpty() {
		String name = null;
		Optional<String> optName = (name == null) ? Optional.empty() : Optional.of(name);
		System.out.println(optName.get());// get method make
		// NoSuchElementException: No value
		// present
	}

	private void nameOrElse() {
		String name = null;
		Optional<String> optName = Optional.ofNullable(name);
		System.out.println(optName.orElse("Name is null."));
	}

	private void nameOrElseGet() {
		String name = null;
		Optional<String> optName = Optional.ofNullable(name);
		System.out.println(optName.orElseGet(() -> "WHAT! null!"));// lambda
	}

	private void nameOrElseThrow() {
		class MyException extends Exception {
			public MyException(String message) {
				super(message);
			}
		}
		String name = null;
		Optional<String> optName = Optional.ofNullable(name);
		try {
			System.out.println(optName.orElseThrow(() -> new MyException("WHAT! NULL!")));
		} catch (MyException e) {
			System.out.println("MY EXCEPTION! " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new MyOptionalExample().nameNotNull();
		new MyOptionalExample().nameNull();
		new MyOptionalExample().nameNullable();
		new MyOptionalExample().nameIsPresent();
		new MyOptionalExample().nameEmpty();
		new MyOptionalExample().nameOrElse();
		new MyOptionalExample().nameOrElseGet();
		new MyOptionalExample().nameOrElseThrow();
	}
}
/**
 * @Java 8 - Optional
 *
 * @Optional 是值的容器，只有兩種狀態，不是有值就是沒值。目的是做為 null 的替代方案。Optional 提供工廠方法，將你輸入的值產生為
 * @Optional 物件，這時Optional 物件即為該值的容器，若要取回該值，必須使用 get() 方法。
 * @Optional 屬於 value-based ，對於識別敏感的操作(包含參考相等的判斷(==)、hash
 *           code或同步(synchronization)等)會有不確定性的結果，應該要避免使用這些操作。
 *
 * @[Java] Java8 新功能筆記(4) - Optional
 * @http://www.tuicool.com/articles/ERBzIrE
 *
 * @Tony Blog: [Java] Java8 新功能筆記(4) - Optional
 * @http://blog.tonycube.com/2015/10/java-java8-4-optional.html
 *
 */
