import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {

    public static void main(String[] args) {
        // 查询某个Object在数组中的位置,可以指定起始搜索位置,找不到返回-1
        // 从正序开始搜索,搜到就返回当前的index否则返回-1
        ArrayUtils.indexOf(new int[]{1, 3, 6}, 6); // =  2
        ArrayUtils.indexOf(new int[]{1, 3, 6}, 2); // =  -1

        System.out.println(ArrayUtils.toMap(new Object[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}}));// fastMap
    }
}

/**
 * ArrayUtils就这1张图，必备（三） - 简书
 * http://www.jianshu.com/p/7461c79f0113
 */