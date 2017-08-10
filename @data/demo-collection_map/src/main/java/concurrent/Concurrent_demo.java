package concurrent;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrent_demo {

    static void concurrentHashMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 1; i < 11; i++) {
            concurrentHashMap.put(i, i);
        }
        System.out.println(concurrentHashMap.size());
    }

    static void concurrentSetTest() {
        Set<String> names = Collections.newSetFromMap(
                new ConcurrentHashMap<String, Boolean>()
        );
        names.add("Brian Goetz");
        names.add("Victor Grazi");
        names.add("Heinz Kabutz");
        names.add("Brian Goetz");
        System.out.println("names = " + names);
    }


    public static void main(String[] args) {
        concurrentHashMap();
        concurrentSetTest();
    }
}
