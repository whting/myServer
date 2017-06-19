package concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class Concurrent_demo {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 1; i < 11; i++) {
            concurrentHashMap.put(i, i);
        }
        System.out.println(concurrentHashMap.size());
    }
}
