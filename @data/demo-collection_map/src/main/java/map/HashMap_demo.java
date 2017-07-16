package map;

import java.util.*;

public class HashMap_demo {

    public static void structure(){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 1; i < 11; i++) {
            int value = (int)(Math.random()*100);
            hashMap.put(value, value);
        }
        System.out.println(hashMap.size());

        System.out.println("-------------------------");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 1; i < 11; i++) {
            linkedHashMap.put(i, i);
        }
        System.out.println(linkedHashMap.size());

        System.out.println("-------------------------");
        TreeMap treeMap = new TreeMap();
        for (int i = 1; i < 11; i++) {
            treeMap.put(i, i);
        }
        System.out.println(treeMap.size());
    }

    public static void sort(){
        int[] ints= {1,3,2,4,7,9,6,7,8,6,5,4,3,2};
        TreeSet treeSet = new TreeSet();
        for (int i=0;i<ints.length;i++){
            treeSet.add(ints[i]);
        }
        System.out.println(treeSet);// 排序

        HashSet hashSet = new HashSet();
        for (int i=0;i<ints.length;i++){
            hashSet.add(ints[i]);
        }
        System.out.println(hashSet);// 有序？

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i=0;i<ints.length;i++){
            linkedHashSet.add(ints[i]);
        }
        System.out.println(linkedHashSet);// 保持顺序
    }

    public static void main(String[] args) {
        structure();
//        sort();
    }
}

/**
 * hashMap = {HashMap@466}
 * table = {HashMap$Node[16]@467}
 * entrySet = {HashMap$EntrySet@470}  size = 8
 * size = 8
 * modCount = 8
 * threshold = 12 阈值
 * loadFactor = 0.75
 * keySet = null
 * values = null
 * <p>
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 * <p>
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 * <p>
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 * <p>
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 * <p>
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 */

/**
 * Java常考面试题 - Java集合类框架的最佳实践有哪些？
 * http://www.jianshu.com/p/bfbe2858c21f
 */
