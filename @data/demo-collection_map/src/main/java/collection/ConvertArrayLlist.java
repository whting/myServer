package collection;

import org.apache.commons.beanutils.ConvertUtils;

import java.util.*;

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
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        System.out.println(list.toArray());// [Ljava.lang.Object;@14ae5a5
        System.out.println(list);// [1, 2]
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
    }

    /**
     * List2StringFormat 格式化
     */
    static void List2StringFormat() {
        List<String> a = new ArrayList<String>();
        a.add("aa");
        a.add("bb");
        a.add("cc");
        System.out.println(a.toString().replace("[", "").replace("]", "").replace(" ", ""));
        // aa,bb,cc
    }

    static void strings2Longs() {
        Long[] longs = (Long[]) ConvertUtils.convert(new String[]{"1", "2", "3"}, Long.class);// String[] 转Long[] 数组
        System.out.println(Arrays.asList(longs));// [1, 2, 3]
    }

    /**
     * fastList - 快速建立
     */
    static void fastList() {
        List list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list);// [1, 2, 3, 4]
    }

    public static void main(String[] args) {
        array2List();
        list2Array();

        list2Set();

        List2StringFormat();
        strings2Longs();

        fastList();
    }
}
