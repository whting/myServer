package reflect.material3;

import java.lang.reflect.Field;

public class TestPrivate2 {
    public static void main(String[] args)throws Exception {
        Private2 p = new Private2();
        Class<?> classType = p.getClass();

        Field field = classType.getDeclaredField("name");// 访问私有函数
        field.setAccessible(true);// 无障碍
        field.set(p,"lisi");
        System.out.println(p.getName());
    }
}