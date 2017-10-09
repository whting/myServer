import java.util.Arrays;

/**
 * 快速排序
 * @author liuxiang on 2017/8/10.
 */
public class QuickSortDemo {


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(Integer[] numbers, int low, int high) {
        // 示例:[6, 2, 1, 8, 5, 4, 9, 3, 7]中轴值为6,分治法结果[32145]6[987](交换)/[21543]6[897](分区)

        int temp = numbers[low]; // 数组的第一个作为中轴
        numbers[low] = null;// 原位置值已经转移,未来也会被分治法的新值覆盖,可省略.但标记null,方便理解
        while (low < high) {
            while (low < high && numbers[high] > temp) {// 先最高位与中轴值比较
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            numbers[high] = null;// 原位置值已经转移,未来也会被分治法的新值覆盖,可省略.但标记null,方便理解
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
            numbers[low] = null;// 原位置值已经转移,未来也会被分治法的新值覆盖,可省略.但标记null,方便理解
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(Integer[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二

            System.out.printf("low:%d high:%d middleIndex:%d-%d %n", low, high, middle,numbers[middle]);
            System.out.println(Arrays.asList(numbers));// 定位中位数时,已经完成分治

            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }

    }


    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        System.out.println("排序前：" + Arrays.asList(numbers));

        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("快速排序后：" + Arrays.asList(numbers));// [-5, 0, 1, 2, 6, 7, 10, 15, 20, 55]
    }
}
/**
 *
 * `必须知道的八大种排序算法【java实现】（一） 冒泡排序、快速排序 - WhyWin - 博客园`
 * http://www.cnblogs.com/0201zcr/p/4763806.html
 */