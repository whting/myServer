package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMap_demo {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 1; i < 11; i++) {
            hashMap.put(i, i);
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
