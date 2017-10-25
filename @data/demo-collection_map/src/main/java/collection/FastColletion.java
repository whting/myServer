package collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * 快速建立
 *
 * @author liuxiang on 2017/8/10.
 */
public class FastColletion {

    /**
     * fastList - 快速建立
     */
    static void fastList() {
        List list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(list);// [1, 2, 3]

        list = Arrays.asList(1, 2, 3, 4);// jdk
        System.out.println(list);// [1, 2, 3, 4]

        list = Lists.newArrayList(1, 2, 3, 4);// google guava
        System.out.println(list);// [1, 2, 3, 4]

        list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5);// 填充 jdk1.5
        System.out.println(list);
    }

    static void fastMap() {
        Map map = new HashMap() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
            put(4, 4);
        }};
        System.out.println(map);

        // 二维数组2map
        map = ArrayUtils.toMap(new Object[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}});
        System.out.println(map);
    }

    static void fastSet() {
        Sets.newHashSet(1, 2, 3, 3, 4, 4, 4, 5, 6).forEach(System.out::println);
        System.out.println(Sets.newHashSet(1, 2, 3, 3, 4, 4, 4, 5, 6));
    }

    public static void main(String[] args) {
        fastList();
//        fastMap();
//        fastSet();
    }
}
