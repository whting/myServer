package set;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet();
        TreeSet<Integer> treeSet = new TreeSet();

        for (int i = 0; i < 10; i++) {
            int value = (int) (Math.random() * 100);
            hashSet.add(value);
            treeSet.add(value);
        }

        System.out.println(hashSet);
        System.out.println(treeSet);

        // iter 遍历
        for (Integer value : hashSet) {
            System.out.print(value + " ");
        }
        System.out.println();
        for (Integer value : treeSet) {
            System.out.print(value + " ");
        }
    }
}
/**
 * 内存数据结构可见,内部基本由Map(HashMap,TreeMap)实现[value=private static final Object PRESENT = new Object()]
 */