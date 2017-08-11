package collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuxiang on 2017/8/11.
 */
public class CollectionConsole {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list);// 打印list

        Integer[] values = (Integer[]) list.toArray();// List 转 Array
        System.out.println(Arrays.asList(values));// 打印数组(转list)

        int[] valuesI = new int[values.length];
        Arrays.stream(values).forEachOrdered(i -> valuesI[i - 1] = values[i - 1].intValue());// 封装数组转基础数组(Integer[] 转 int[])
        Arrays.stream(valuesI).forEach(value -> System.out.print(value+", "));// 打印基础类型数组(int[])
    }
}
