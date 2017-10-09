import java.util.*;

/**
 * @author liuxiang on 2017/8/10.
 */
public class SortingUtil {

    /**
     * jdk排序工具
     * <p>
     * java工具类-排序介绍 - CSDN博客
     * http://blog.csdn.net/qiyeliuli/article/details/51446566
     */
    public static void sortByJdk() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// 洗牌,打乱
        System.out.println(list);

        Collections.sort(list);// 默认升序
        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());// 降序
        System.out.println(list);

        Collections.shuffle(list);// 洗牌,打乱
        Collections.sort(list, new Comparator<Integer>() {// 自定义排序
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//使用Collections的sort方法，并且重写compare方法
        System.out.println(list);

        Collections.shuffle(list);// 洗牌,打乱
        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);

        Collections.shuffle(list);// 洗牌,打乱
        Object[] lis = list.toArray();
        Arrays.sort(lis);// 对数组排序
        System.out.println(Arrays.asList(lis));
    }

    public static void sortByDataStructure() {
        /* TreeSet */
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// 洗牌,打乱
        System.out.println(list);

        TreeSet treeSet = new TreeSet();
        treeSet.addAll(list);
        System.out.println(treeSet);// TreeSet数据结构天然排序

        Iterator iterator1 = treeSet.descendingIterator();// Iterator 降序
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        /* Map */
        Map map = new HashMap() {{
            put(2, 2);
            put(1, 1);
            put(4, 4);
            put(3, 3);
        }};
        System.out.println(map);// Map数据结构天然排序
    }

    public static void sortByGoogle() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// 洗牌,打乱

    }

    /**
     * ﻿比较器Comparable接口和Comaprator接口
     * <p>
     * * 以下关于Comparable和Comparator的基础知识摘自博客:http://uule.iteye.com/blog/766688
     * <p>
     * 1.Comparable接口是在java.lang类中的，而Comparator接口是在java.util类中的。
     * 2.Comparable 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序，所以，如想实现排序，就需要在集合外定义 Comparator 接口的方法或在集合内实现 Comparable 接口的方法。
     * <p>
     * 用自定义类实现 Comparable接口，那么这个类就具有排序功能，Comparable和具体你要进行排序的类的实例邦定。
     * <p>
     * 而Comparator比较灵活，它没有和任何类绑定，实现它的自定义类仅仅定义了一种排序方式或排序规则。不言而喻，这种方式比较灵活。我们的要排序的类可以分别和多个实现 Comparator接口的类绑定，从而达到可以按自己的意愿实现按多种方式排序的目的。Comparable——“静态绑定排序”,Comparator——“动态绑定排序”。
     */
    public static void sortByCC() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// 洗牌,打乱
        System.out.println(list);

        // java.util.Comparator 集合外定义排序
        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);

        Collections.shuffle(list);// 洗牌,打乱

        // java.lang.Comparable 集合内定义排序
        SortNode sns[]={new SortNode(2),new SortNode(1),new SortNode(4),new SortNode(3)};
        java.util.Arrays.sort(sns);
        for (SortNode sortNode : sns) {
            System.out.print(sortNode.number+ " ");
        }
        System.out.println();
    }

    static class SortNode implements Comparable<SortNode>{
        int number;

        public SortNode(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(SortNode o) {
            return o.number > this.number ? -1 : 1;
        }
    }


    public static void main(String[] args) {
//        sortByJdk();
//        sortByDataStructure();
//        sortByGoogle();
        sortByCC();
    }
}