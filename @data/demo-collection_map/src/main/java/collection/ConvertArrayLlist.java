package collection;

import com.google.common.collect.Sets;
import org.apache.commons.beanutils.ConvertUtils;

import java.util.*;

/**
 * ﻿List,Array互转与打印
 * 快速构建List / List 转 Array / Array 转 List
 * 封装数组转基础数组(Integer[] 转 int[]) / 打印基础类型数组(int[])
 */
public class ConvertArrayLlist {

    /**
     * array2List - asList
     */
    static void array2List() {
        Object[] obj = new Object[]{1, 2, 3, 4, 5};
        System.out.println(obj);// [Ljava.lang.Object;@14ae5a5
        System.out.println(Arrays.asList(obj));// [1, 2, 3, 4, 5]
    }

    /**
     * list2Array - toArray
     */
    static void list2Array() {
        List list = Arrays.asList(1, 2);
        Integer[] arrays = (Integer[]) list.toArray();
        System.out.println(arrays);// [Ljava.lang.Object;@14ae5a5
        System.out.println(Arrays.asList(arrays));// [1, 2]
    }

    /**
     * list2Set
     */
    static void list2Set() {
        List list = Arrays.asList(1, 2, 3, 4);

        Set set = new HashSet() {{
            addAll(list);
        }};

        System.out.println(set);
        System.out.println(new HashSet<>(list));
    }

    /**
     * set转list
     */
    static void set2Array() {
        Set set = Sets.newHashSet(1, 2, 3, 3, 4, 4, 4, 5, 6);
        System.out.println(new ArrayList<>(set));
    }

    /**
     * List2StringFormat 格式化 (aa,bb,cc)
     */
    static void List2StringFormat() {
        List<String> a = Arrays.asList("aa", "bb", "cc");
        System.out.println(a.toString().replace("[", "").replace("]", "").replace(" ", ""));

    }

    static void strings2Longs() {
        Long[] longs = (Long[]) ConvertUtils.convert(new String[]{"1", "2", "3"}, Long.class);// String[] 转Long[] 数组
        System.out.println(Arrays.asList(longs));// [1, 2, 3]
    }

    /**
     * 封装数组转基础数组(Integer[] 转 int[])
     */
    static void IntegerArray2intArray() {
        Integer[] values = {1, 2, 3, 4, 5};
        int[] valuesI = new int[values.length];
        Arrays.stream(values).forEachOrdered(i -> valuesI[i - 1] = values[i - 1].intValue());// 封装数组转基础数组(Integer[] 转 int[])
        Arrays.stream(valuesI).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
    }


    public static void main(String[] args) {
//        array2List();
//        list2Array();
//
//        list2Set();
        set2Array();
//
//        List2StringFormat();
//        strings2Longs();
//
//        IntegerArray2intArray();


    }
}
