import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuxiang on 2017/8/10.
 */
public class SortingDemo {

    public static void main(String[] args) {
        /* 简单排序 */
//        EasySort.bubbleList();// 冒泡
//        EasySort.bubbleArray();// 冒泡
//        EasySort.xuanze();// 选择
//        EasySort.charu();// 插入

        /* 高效排序 */
        QuickSort.quickSort();// 快排
//        MergeSort.mergeSort();// 归并排序(分治递归思想)
//        ShellSort.shellSort();// 希尔排序(插入排序的一种高效率的实现，也叫缩小增量排序)
        // 堆排序(升序排序就使用大顶堆，反之使用小顶堆)

        /* 线性排序 */
        // 计数排序
        // 桶排序
        // 基数排序
    }
}

/**
 * 简单排序
 */
class EasySort {
    /**
     * 冒泡排序 List
     * <p>
     * 算法思想：遍历待排序的数组，每次遍历比较相邻的两个元素，如果他们的排列顺序错误就交换他们的位置，
     * 经过一趟排序后，最大的元素会浮置数组的末端。重复操作，直到排序完成。
     */
    static void bubbleList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                int current = list.get(j);
                int comp = list.get(j + 1);
                if (current > comp) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
            System.out.println(list);
        }
    }

    /**
     * 冒泡排序 Array (循环最大值置顶)
     * <p>
     * 算法思想：遍历待排序的数组，每次遍历比较相邻的两个元素，如果他们的排列顺序错误就交换他们的位置，
     * 经过一趟排序后，最大的元素会浮置数组的末端。重复操作，直到排序完成。
     */
    static void bubbleArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                int current = values[j];
                int comp = values[j + 1];
                if (current > comp) {
                    int temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }
            System.out.println(Arrays.asList(values));
        }
    }


    /**
     * 选择排序
     * <p>
     * 算法思想：重待排序的数组中选择一个最小的元素，将它与数组的第一个位置的元素交换位置。
     * 然后从剩下的元素中选择一个最小的元素，将它与第二个位置的元素交换位置，
     * 如果最小元素就是该位置的元素，就将它和自身交换位置，依次类推，直到排序完成。
     */
    static void xuanze() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));

        Integer[] array = values;
        for (int i = 0; i < values.length; i++) {
            int courrentMinIndex = i;// 当前最小值下标

            // 从当前下标到最后的范围,找出最小的值
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[courrentMinIndex]) {
                    courrentMinIndex = j;
                }
            }

            // 当前位与最小值位交换
            int temp = values[i];
            values[i] = values[courrentMinIndex];
            values[courrentMinIndex] = temp;

            System.out.println(Arrays.asList(array));
        }
    }

    /**
     * 插入排序(优先保障currentIndex前置有序)
     * <p>
     * 算法思想:从数组的第二个元素开始遍历，将该元素与前面的元素比较，如果该元素比前面的元素小，
     * 将该元素保存进临时变量中，依次将前面的元素后移，然后将该元素插入到合适的位置。
     * 每次排序完成后，索引左边的元素一定是有序的，但是还可以移动。对于倒置越少的数组，该算法的排序效率越高。
     */
    static void charu() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));

        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < i; j++) {
                int current = values[i];
                int comp = values[j];
                if (current < comp) {
                    int third = values[i];
                    values[i] = values[j];
                    values[j] = third;
                }
            }
            System.out.println(Arrays.asList(values));
        }
    }
}

/**
 * 快速排序
 */
class QuickSort {
    /**
     * 快速排序的基本思想：通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
     * 则分别对这两部分继续进行排序，直到整个序列有序。
     */
    static void quickSort() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        System.out.println("======(分区)");
        Integer[] values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));
        quickSortEasy(values, 0, values.length - 1);


        System.out.println("======(交换)");
        values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));
        quickSortSwap(values, 0, values.length - 1);

    }

    /**
     * 分治法-分区(方便理解)
     *
     * @param values
     * @param begin
     * @param end
     */
    static void quickSortEasy(Integer[] values, int begin, int end) {
        if (begin >= end) return;

        int middleIndex = quickSortMiddleEasy(values, begin, end);

        System.out.printf("begin:%d end:%d middleIndex:%d(value=%d) %n", begin, end, middleIndex, values[middleIndex]);
        System.out.println(Arrays.asList(values));// 定位中位数时,已经完成分治

        quickSortEasy(values, begin, middleIndex - 1);
        quickSortEasy(values, middleIndex + 1, end);
    }

    static int quickSortMiddleEasy(Integer[] values, int begin, int end) {
        // 第一步,以最低位值作为中轴,将其它数进行两边分治法.结束后,中轴位不再参与后续排序(因为位置已经确定了)
        // 示例:[6, 2, 1, 8, 5, 4, 9, 3, 7]中轴值为6,分治法结果[32145]6[987](交换)/[21543]6[897](分区)
        int middleValue = values[begin];

        // 第二步,分治法.先腾出中轴值位置[0],并保持中轴值.
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.addAll(Arrays.asList(Arrays.copyOfRange(values, 0, begin)));// 排序区间前
        for (int i = begin; i < end + 1; i++) {
            if (values[i] < middleValue) {
                left.add(values[i]); // 排序区间左区
            } else if (values[i] > middleValue) {
                right.add(values[i]);// 排序区间右区
            }
        }
        left.add(middleValue);// 排序区间中轴
        int middleIndex = left.size() - 1;
        left.addAll(right);// 排序区间右区也合并到单个集合
        left.addAll(Arrays.asList(Arrays.copyOfRange(values, end + 1, values.length)));// 排序区间后

        values = left.toArray(values);// 重写原数组
        return middleIndex;
    }

    /**
     * 分治法-交换(节省内存空间)
     * @param values
     * @param begin
     * @param end
     */
    static void quickSortSwap(Integer[] values, int begin, int end) {
        if (begin >= end) return;

        int middleIndex = getMiddle(values, begin, end);

        System.out.printf("begin:%d end:%d middleIndex:%d(value=%d) %n", begin, end, middleIndex, values[middleIndex]);
        System.out.println(Arrays.asList(values));// 定位中位数时,已经完成分治

        quickSortSwap(values, begin, middleIndex - 1);
        quickSortSwap(values, middleIndex + 1, end);
    }


    public static int getMiddle(Integer[] numbers, int low, int high) {

        // 示例:[6, 2, 1, 8, 5, 4, 9, 3, 7]中轴值为6,分治法结果[32145]6[987](交换)/[21543]6[897](分区)

        int temp = numbers[low]; // 数组的第一个作为中轴
        numbers[low] = null;// 原位置值已经转移,未来也会被分治法的新值覆盖,可省略.但标记null,方便理解
        while (low < high) {
            while (low < high && numbers[high] > temp) {// 先最高位与中轴值比较
                high--;
            }
            numbers[low] = numbers[high];// 比中轴小的记录移到低端
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

}

/**
 * 归并排序
 */
class MergeSort {
    static void mergeSort() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();
        System.out.println(Arrays.asList(values));

        middleSort(values, 0, values.length);
    }

    static int markNum=0;

    static void middleSort(Integer[] values, int beginIndex, int endIndex) {
        if (!(beginIndex < endIndex))
            return;

        int mid = (beginIndex + endIndex) / 2;// 取中位index

        middleSort(values, beginIndex, mid);// 左侧递归再分,到不可再分
        middleSort(values, mid + 1, endIndex);// 右侧递归再分,到不可再分

        // 对最近的二分数据进行合并. 如:[5,6,7][1,2]
        // 待合并的二分数据,已经基本有序,所有使用`插入排序`进行合并,具备更高的性能(因为移动的位置较少)且不需要更多的内存仅需一个交换变量.(或考虑希尔排序)
        for (int i = beginIndex + 1; i < endIndex; i++) {
            for (int j = beginIndex; j < i; j++) {
                if (values[i] < values[j]) {
                    int temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                    System.out.println("markNum:"+markNum++);
                }
            }
        }
        System.out.println(Arrays.asList(values));

    }
}

/**
 * 希尔排序
 */
class ShellSort {

     static void shellSort() {
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
 * `﻿★面试中的排序算法总结 - 简书`
 * http://www.jianshu.com/p/c360a58db21d
 * <p>
 * `三种简单排序算法（java实现） - rising1234 - 博客园`
 * http://www.cnblogs.com/coderising/archive/2016/07/22/5697072.html
 * <p>
 * `java使数组元素打乱? - 知乎`
 * https://www.zhihu.com/question/31979419
 */