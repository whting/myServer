package skiplist;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkiplistDemo {

    static void m_ConcurrentSkipListMap() {
        Map skipListMap = new ConcurrentSkipListMap();
        for (int i = 0; i < 10; i++) {
            int kv = (int) (Math.random() * 100);
            skipListMap.put(kv, kv);
        }
        System.out.println(skipListMap);// {4=4, 9=9, 13=13, 30=30, 44=44, 49=49, 59=59, 66=66, 89=89, 95=95}
    }

    static void m_ConcurrentSkipListSet() {
        Set skipListSet = new ConcurrentSkipListSet();
        for (int i = 0; i < 10; i++) {
            int kv = new Random().nextInt(100);
            skipListSet.add(kv);
        }
        System.out.println(skipListSet);// [4, 14, 31, 45, 48, 52, 54, 59]
    }

    public static void main(String[] args) {
        m_ConcurrentSkipListMap();
        m_ConcurrentSkipListSet();
    }
}

/**
 * 在Java的API中已经有了实现：分别是
 * ConcurrentSkipListMap(在功能上对应HashTable、HashMap、TreeMap);
 * ConcurrentSkipListSet(在功能上对应HashSet);
 * <p>
 * 跳跃表Skip List的原理和实现-博客-云栖社区-阿里云
 * https://yq.aliyun.com/articles/38381
 */