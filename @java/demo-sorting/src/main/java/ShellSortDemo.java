import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王旭
 * @Description:<p>希尔排序算法实现</p>
 * @time 2016-3-3 下午10:53:55
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();// List 转 Array
        System.out.println(Arrays.asList(values));

        int[] valuesI = new int[values.length];
        Arrays.stream(values).forEachOrdered(i -> valuesI[i - 1] = values[i - 1].intValue());// 封装数组转基础数组(Integer[] 转 int[])
        Arrays.stream(valuesI).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.println();

        int[] valuesI2 = new int[]{8, 7, 4, 1, 3, 5, 6, 2, 9};// 自定义
        shellSort(valuesI2);
        Arrays.stream(valuesI2).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
    }

    /**
     * 希尔排序的一趟插入
     *
     * @param arr 待排数组
     * @param d   增量
     */
    public static void shellInsert(int[] arr, int d) {
        System.out.println("d:" + d);
        for (int i = d; i < arr.length; i++) {
            int j = i - d;
            int temp = arr[i];    //记录要插入的数据  
            while (j >= 0 && arr[j] > temp) {  //从后向前，找到比其小的数的位置
                arr[j + d] = arr[j];    //向后挪动
                j -= d;
            }

            if (j != i - d)    //存在比其小的数 
                arr[j + d] = temp;

            Arrays.stream(arr).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
            System.out.println();
        }
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }

}

/**
 * 8, 7, 4, 1, 3, 5, 6, 2, 9
 * length/2=4
 * -           -
 * -           -
 * -           -
 * - 		     -
 * -           -
 * 3, 5, 4, 1, 8, 7, 6, 2, 9
 * 4/2=2
 * -     -
 * -     -
 * -     -
 * -     -
 * -     -     -
 * -     -     -
 * -     -     -     -
 * x     x
 * 1     5
 * x     8
 * x     7
 * x     6     8
 * 2     5     7
 * x     x     x     9
 * 3, 1, 4, 2, 6, 5, 8, 7, 9
 * 2/2=1
 * -  -
 * -  -
 * -  -  -
 * -  -  -  -
 * -  -  -  -  -
 * -  -  -  -  -  -
 * -  -  -  -  -  -  -
 * -  -  -  -  -  -  -  -
 * 1  3 i=1
 * x  x i=2
 * 2  3  4 i=3
 * x  x  x  6 i=4
 * x  x  x  5  6 i=5
 * x  x  x  x  X  8 i=6
 * x  x  x  x  X  7  8 i=7
 * x  x  x  x  X  x  x  x  9 i=8
 */