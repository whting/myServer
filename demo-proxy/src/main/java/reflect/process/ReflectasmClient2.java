package reflect.process;

import java.lang.reflect.Method;

import reflect.material.SomeClass;

import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectasmClient2
{

	public static void main(String[] args) throws Exception
	{
		testJdkReflect();
		// testReflectAsm();
	}

	public static void testJdkReflect() throws Exception
	{
		SomeClass someObject = new SomeClass();
		Method method = SomeClass.class.getMethod("foo", String.class);
		for (int i = 0; i < 5; i++)
		{
			long begin = System.currentTimeMillis();
			for (int j = 0; j < 100000000; j++)
			{
				method.invoke(someObject, "Unmi");
			}
			System.out.print(System.currentTimeMillis() - begin + " ");
		}
	}

	public static void testReflectAsm()
	{
		SomeClass someObject = new SomeClass();
		MethodAccess access = MethodAccess.get(SomeClass.class);
		for (int i = 0; i < 5; i++)
		{
			long begin = System.currentTimeMillis();
			for (int j = 0; j < 100000000; j++)
			{
				access.invoke(someObject, "foo", "Unmi");
			}
			System.out.print(System.currentTimeMillis() - begin + " ");
		}
	}

}