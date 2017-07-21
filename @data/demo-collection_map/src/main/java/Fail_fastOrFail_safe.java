import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class Fail_fastOrFail_safe {

    public static void hashtable() {
        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put("a", "aa");
        table.put("b", "bb");
        table.put("c", "cc");
        table.remove("c");
        Iterator<Map.Entry<String, String>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue()); // ConcurrentModificationException
            // 采用iterator直接进行修改 程序正常
            iterator.remove();

            // 直接从hashtable增删数据就会报错
            table.put("d", "dd");

            // 直接从hashtable增删数据就会报错，hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，就是快速失败
            table.remove("c");
        }
        System.out.println("-----------");
    }

    public static void hashMap() {
        Lock lock = new ReentrantLock();

        // 即使加上lock，还是会跑出ConcurrentModificationException异常
        lock.lock();
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("a", "aa");
        hashmap.put("b", "bb");
        hashmap.put("c", "cc");
        Iterator<Map.Entry<String, String>> iterators = hashmap.entrySet().iterator();
        while (iterators.hasNext()) {
            System.out.println(iterators.next().getValue());// ConcurrentModificationException
            // 正常
            iterators.remove();

            // 直接从hashtable增删数据就会报错。
            // hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，会快速失败 (一检测到修改，马上抛异常)
            // java.util.ConcurrentModificationException
            hashmap.remove("c");
        }
        System.out.println("-----------");

        lock.unlock();
    }

    public static void concurrentHashMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        Iterator<Map.Entry<String, String>> mapiterator = map.entrySet().iterator();
        while (mapiterator.hasNext()) {
            System.out.println(mapiterator.next().getValue());
            map.remove("c");// 正常 并发集合不存在快速失败问题
            map.put("c", "cc");// 正常 并发集合不存在快速失败问题
        }
        System.out.println("-----------");
    }

    public static void main(String[] args) throws InterruptedException {

//        Fail_fastOrFail_safe.hashtable();// 快速失败
//        Fail_fastOrFail_safe.hashMap();// 快速失败
        Fail_fastOrFail_safe.concurrentHashMap();// 安全失败
    }
}

/**
 * Java基础之——快速失败&安全失败（最全的总结） - chtxia的专栏 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/rexct392358928/article/details/51773481
 * <p>
 * 在java.util包下的都是快速失败。
 * hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，会快速失败 (一检测到修改，马上抛异常)
 * <p>
 * 在java.util.concurrent包下的全是安全失败的
 * 并发集合不存在快速失败问题
 */