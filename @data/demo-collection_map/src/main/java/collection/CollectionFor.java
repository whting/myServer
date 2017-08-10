package collection;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CollectionFor {

    static void forList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        System.out.println();

        list.stream().forEach(value -> System.out.print(value + " "));// java8 stream
    }

    static void forMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
        System.out.println(map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue()+",");
        }

        System.out.println();
        Object[][] objects = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        Stream.of(objects).forEach(e -> System.out.print(e[0]+" "+e[1]+","));
        System.out.println();
    }

    /**
     * fastMap - ArrayUtils.toMap
     * 使用二维数组,快速建立Map
     */
    static void fastMap() {
        // 快速创建map
        System.out.println(ArrayUtils.toMap(new Object[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}}));
    }

    public static void main(String[] args) {
//        forList();
        forMap();
//        fastMap();
    }
}
