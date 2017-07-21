package java8.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    static void streamMap(){
        Map<Integer, List<Integer>> map = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x->x));
        System.out.println(map);

        Map<Integer, Long> map2 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map2);

        HashMap<Integer, Long> hashMap = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));
        System.out.println(hashMap);
    }

    public static void main(String[] args) {
        streamMap();
    }
}
