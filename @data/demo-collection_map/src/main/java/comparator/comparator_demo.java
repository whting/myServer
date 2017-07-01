package comparator;

import java.util.*;

public class comparator_demo {

    public static void demo_sort() {
        int[] inte = {1, 3, 2, 4, 5, 2, 3, 5, 6, 7, 3};
        Arrays.sort(inte);
        System.out.println(Arrays.toString(inte));
    }

    /**
     * Comparator,自定义排序
     */
    public static void demo_Comparator_Array() {
        Comparator<Integer> OrderIsdn = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Integer[] inte = {1, 3, 2, 4, 5, 2, 3, 5, 6, 7, 3};
        Arrays.sort(inte, OrderIsdn);
        System.out.println(Arrays.toString(inte));
    }

    /**
     * Comparator,自定义排序
     */
    public static void demo_Comparator_List() {
        Comparator<Integer> OrderIsdn = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        List list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(3);
        Collections.sort(list, OrderIsdn);
        System.out.println(list);
    }

    public static void main(String args[]) {
        demo_sort();
        demo_Comparator_Array();
        demo_Comparator_List();
    }
}

/**
 * 【java】Comparator的用法 - 峰峯的专栏 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/u012250875/article/details/55126531
 * <p>
 * Comparable与Comparator的区别 - DemonWang - 博客园
 * http://www.cnblogs.com/houziwty/p/5104845.html
 */