import java.util.Arrays;

/**
 * @author liuxiang on 2017/8/10.
 */
public class ArraysSubDemo {

    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    public static void main(String[] args) {
        Integer [] data = {11,12,13,14,15,16,17,18,19};
        Integer [] newData;
        newData = Arrays.copyOfRange(data, 2, 7);// 截取index2开始至第7位
        System.out.println(Arrays.asList(data));
        System.out.println(Arrays.asList(newData));
    }
}

/**
 * `java中怎么从一个数组中截取一定长度的元素放到新数组中_百度知道`
 * https://zhidao.baidu.com/question/311461213.html
 *
 * `Java实现字节数组中截取指定长度数组元素 - 博客频道 - CSDN.NET`
 * http://blog.csdn.net/u010277446/article/details/52459613
 */
