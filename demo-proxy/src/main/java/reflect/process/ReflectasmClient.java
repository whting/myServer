package reflect.process;

import com.esotericsoftware.reflectasm.MethodAccess;
import reflect.material.SomeClass;

import java.lang.reflect.Method;

public class ReflectasmClient
{

	public static void main(String[] args) throws Exception
	{
		testJdkReflect();
		// testReflectAsm();
	}

	public static void testJdkReflect() throws Exception
	{
		SomeClass someObject = new SomeClass();
		for (int i = 0; i < 5; i++)
		{
			long begin = System.currentTimeMillis();
			for (int j = 0; j < 100000000; j++)
			{
				Method method = SomeClass.class.getMethod("foo", String.class);
				method.invoke(someObject, "Unmi");
			}
			System.out.print(System.currentTimeMillis() - begin + " ");
		}
	}

	/**
	 * asm反射实现
	 */
	public static void testReflectAsm()
	{
		SomeClass someObject = new SomeClass();
		for (int i = 0; i < 5; i++)
		{
			long begin = System.currentTimeMillis();
			for (int j = 0; j < 100000000; j++)
			{
				MethodAccess access = MethodAccess.get(SomeClass.class);
				access.invoke(someObject, "foo", "Unmi");
			}
			System.out.print(System.currentTimeMillis() - begin + " ");
		}
	}
}