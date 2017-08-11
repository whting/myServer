import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王旭
 * <p>
 * 归并排序算法的实现
 * 其基本思想是：先递归划分子问题，然后合并结果。
 * 把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。
 * 倒着来看，其实就是先两两合并，然后四四合并，最终形成有序序列。
 * @time 2016-3-4 上午8:14:20
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);// list随机打乱
        Integer[] values = (Integer[]) list.toArray();// List 转 Array
        System.out.println(Arrays.asList(values));

        int[] valuesI = new int[values.length];
        Arrays.stream(values).forEachOrdered(i -> valuesI[i - 1] = values[i - 1].intValue());// 封装数组转基础数组(Integer[] 转 int[])
        Arrays.stream(valuesI).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.println();

        mergeSort(valuesI);
        Arrays.stream(valuesI).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
    }

    public static void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归分治
     *
     * @param arr   待排数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void mSort(int[] arr, int left, int right) {
        if (!(left < right))
            return;
        int mid = (left + right) / 2;

        System.out.printf(">begin:%d end:%d mid:%d %n", left, right, mid);
        mSort(arr, left, mid); //﻿左边区域递归(二分),至不可二分

        System.out.printf("begin:%d >end:%d mid:%d %n", mid + 1, right, mid);
        mSort(arr, mid + 1, right); //﻿右边区域递归(二分),至不可二分

        merge(arr, left, mid, right); //合并
        Arrays.stream(arr).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.printf("left:%d right:%d mid:%d %n", left, right, mid);
    }

    /**
     * 合并两个有序数组
     *
     * @param arr   待合并数组
     * @param left  左指针
     * @param mid   中间指针
     * @param right 右指针
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        //[left, mid] [mid+1, right]
        int[] temp = new int[right - left + 1]; //中间数组

        int i = left;
        int j = mid + 1;
        int k = 0;

        // 一.区间范围,排序
        while (i <= mid && j <= right) {
            System.out.printf("%n arr[%d]%d <= arr[%d]%d", i, arr[i], j, arr[j]);
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        System.out.printf("%ntemp(comp):");
        Arrays.stream(temp).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.println();

        // 二.区间左侧,补位
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        System.out.printf("temp(补位左):");
        Arrays.stream(temp).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.println();

        // 三.区间右侧,补位
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.out.printf("temp(补位右):");
        Arrays.stream(temp).forEach(value -> System.out.print(value + ", "));// 打印基础类型数组(int[])
        System.out.println();

        // 将有序的temp区间,复写原array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

    }
}
/**
 * `★面试中的排序算法总结 - 简书` - 归并排序
 * http://www.jianshu.com/p/c360a58db21d
 */