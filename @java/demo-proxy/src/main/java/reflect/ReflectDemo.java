package reflect;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射便利class所有field,method
 */
public class ReflectDemo {

    private String name = "hh";

    private String getName() {
        return name;
    }

    private List ls;

    private void setList(List ls) {
        this.ls = ls;
    }

    private List getList() {
        return this.ls;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {

        System.out.println("成员属性:");
        Field[] fields = ReflectDemo.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field + " = " + field.get(ReflectDemo.class.newInstance()));// field.toString() 完整展示
        }

        System.out.println();

        System.out.println("成员方法:");
        Method[] methods = ReflectDemo.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);// method.toString() 完整展示
        }

        System.out.println("======================================");

        System.out.println("成员属性:");
        Field[] fields2 = ReflectDemo.class.getDeclaredFields();
        for (Field field : fields2) {
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().getName();
            String name = field.getName();
            System.out.println(String.format("%s %s %s;", modifier, type, name));
        }

        System.out.println();

        System.out.println("成员方法:");
        Method[] methods2 = ReflectDemo.class.getDeclaredMethods();
        for (Method method : methods2) {
            String modifier = Modifier.toString(method.getModifiers());
            String returnType = method.getReturnType().getName();
            String methodName = method.getName();
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s %s %s(", modifier, returnType, methodName));
            for (Parameter parameter : method.getParameters()) {
                String typeName = parameter.getParameterizedType().getTypeName();
                String name = parameter.getName();
                builder.append(parameter + ",");// parameter = typeName name
            }
            if (method.getParameters().length > 0) {
                builder.delete(builder.length() - 1, builder.length());
            }
            builder.append(")");
            System.out.println(builder);
        }

        System.out.println("======================================(正确示例)");

        Method[] methods_ = ReflectDemo.class.getDeclaredMethods();
        for (Method method : methods_) {
            System.out.println(method);// method.toString() 完整展示
            if (method.getName().equals("setList")) {
                ReflectDemo reflectDemo = ReflectDemo.class.newInstance();
                method.invoke(reflectDemo, Arrays.asList(1, 2, 3));// private ethod-写
                Field field = ReflectDemo.class.getDeclaredField("ls");
                System.out.println("Field ls:" + field.get(reflectDemo));// private Field-读
            }
        }

        // 正确getDeclaredMethod-private
        Method method = ReflectDemo.class.getDeclaredMethod("setList", List.class);// java.lang.NoSuchMethodException: reflect.ReflectDemo.getName()
        ReflectDemo reflectDemo = ReflectDemo.class.newInstance();
        method.setAccessible(true);
        method.invoke(reflectDemo, Arrays.asList(1, 2, 3, 4));
        Field field = ReflectDemo.class.getDeclaredField("ls");
        System.out.println("Field ls:" + field.get(reflectDemo));// private Field-读

        System.out.println("======================================(错误示例)");

        // 错误getMethod-private
        Method method1 = ReflectDemo.class.getMethod("getName");// java.lang.NoSuchMethodException: reflect.ReflectDemo.getName()
        method1.setAccessible(true);
        method1.invoke(ReflectDemo.class.newInstance());

        Method method2 = ReflectDemo.class.getMethod("setList", List.class);// java.lang.NoSuchMethodException: reflect.ReflectDemo.setList(java.util.List)
        method2.invoke(ReflectDemo.class.newInstance(), Arrays.asList(1, 2, 3));

        MethodAccess access = MethodAccess.get(ReflectDemo.class);
        access.invoke(ReflectDemo.class.newInstance(), "setList", new ArrayList());// java.lang.IllegalArgumentException: Unable to find non-private method: setList with 1 params
    }
}
