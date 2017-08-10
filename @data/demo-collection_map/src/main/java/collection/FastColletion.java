package collection;

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
        List list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list);// [1, 2, 3, 4]

        list = new ArrayList();
        Collections.addAll(list, 1,2,3,4,5);//填充
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

    public static void main(String[] args) {
        fastList();
        fastMap();
    }
}
