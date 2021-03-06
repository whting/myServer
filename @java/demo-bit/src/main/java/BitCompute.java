
import java.io.UnsupportedEncodingException;

/**
 * 位运算 参考：http://www.imooc.com/learn/195 笔记：二进制基础》3-1 位运算》异或运算^,效率最高的变量交换
 * A=A^B;B=A^B;A=A^B;
 * 
 * 注意:使用二进制计算时,有意义的是二进制结果.而转换为十进制,十六进制均没有意义.
 * 
 * @author liuxiang
 *
 */
public class BitCompute extends BitBase {

	/**
	 * 二进制的长度疑问
	 */
	public static void bitLength() {
		// 为什么常见的二进制的长度是32位. 取决于存储二进制的数据类型的范围.
		System.out.println(Integer.toBinaryString(1)); // 1
		System.out.println(Integer.toBinaryString(-1)); // 11111111111111111111111111111111
		System.out.println(Integer.toBinaryString(-1).length()); // 32

		System.out.println(Long.toBinaryString(1)); // 1
		System.out.println(Long.toBinaryString(-1));// 1111111111111111111111111111111111111111111111111111111111111111
		System.out.println(Long.toBinaryString(-1).length()); // 64

		// 基本型别 大小 最小值 最大值
		// char 16-bit Unicode 0 Unicode 2^16-1
		// byte 8-bit -128 +127
		// short 16-bit -2^15 +2^15-1
		// int 32-bit -2^31 +2^31-1
		// long 64-bit -2^63 +2^63-1
		// float 32-bit IEEE754 IEEE754
		// double 64-bit IEEE754 IEEE754
	}

	public static void bitCompute() {

		System.out.println(to32(5));// 参考量

		// 1、左移(放大)( << )
		// 0000 0000 0000 0000 0000 0000 0000 0101 然后左移2位后，低位补0
		// 0000 0000 0000 0000 0000 0000 0001 0100 换算成10进制为20
		System.out.println(to32(5 << 2));// 运行结果是20

		// 2、右移(缩小)( >> ) 高位补`符号位`
		// 0000 0000 0000 0000 0000 0000 0000 0101 然后右移2位，高位补0：(正数补0,负数补1)
		// 0000 0000 0000 0000 0000 0000 0000 0001 换算成10进制为1
		System.out.println();
		System.out.println(to32(5 >> 2));// 运行结果是1

		// 3、无符号右移( >>> ) 高位补0
		// 例如 -5换算成二进制后为：0101 取反加1为1011
		// 1111 1111 1111 1111 1111 1111 1111 1011
		// 我们分别对5进行右移3位、 -5进行右移3位和无符号右移3位：
		System.out.println();
		System.out.println(to32(Integer.toBinaryString(5)));
		System.out.println(to32(Integer.toBinaryString(5 >> 3)));

		System.out.println(to32(Integer.toBinaryString(-5)));
		System.out.println(to32(Integer.toBinaryString(-5 >> 3)));// 结果是-1 (正数补0,负数补1)
		System.out.println(to32(Integer.toBinaryString(-5 >>> 3)));// 结果是536870911(无符号右移,补0)

		// 4、位与( & )- 作用：高位补零？
		// 位与：第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
		System.out.println();
		System.out.println(to32(5));
		System.out.println(to32(3));
		System.out.println(to32(5 & 3));

		// 5、位或( | )
		// 第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
		System.out.println();
		System.out.println(to32(5));
		System.out.println(to32(3));
		System.out.println(to32(5 | 3));

		// 6、位异或( ^ ) - 作用：？
		// 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
		System.out.println();
		System.out.println(to32(5));
		System.out.println(to32(3));
		System.out.println(to32(5 ^ 3));

		// 7、位非( ~ )
		// 操作数的第n位为1，那么结果的第n位为0，反之。
		System.out.println();
		System.out.println(to32(5));
		System.out.println(to32(~5));
	}

	public static void bitCompute32(){
		System.out.println(5>>3);//结果是0
		System.out.println(-5>>3);//结果是-1
		System.out.println(-5>>>3);//结果是536870911

		/**
		 * Java 位运算(移位、位与、或、异或、非） - Ely's Blog - CSDN博客
		 * http://blog.csdn.net/xiaochunyong/article/details/7748713
		 */
	}

	public static void bitCompute_imooc() throws UnsupportedEncodingException {

		String s = "慕课ABC";

		System.out.println();
		System.out.println(to32(0xff));// 1byte=8位,多余的前缀都是无效的. 通过[& 0xff]剔除干扰


		byte[] utf8 = s.getBytes("utf-8");
		for (byte b : utf8) {
			// UTF-8 编码中中文占用3个字节
			System.out.print(Integer.toBinaryString(b & 0xff) + " ");
		}

		System.out.println();
		for (byte b : utf8) {
			// GBK 编码中中文占用2个字节
			System.out.print(Integer.toHexString(b & 0xff) + " ");// 16进制显示
		}

		System.out.println();
		byte[] gbk = s.getBytes("gbk");
		for (byte b : gbk) {
			System.out.print(Integer.toBinaryString(b & 0xff) + " ");
		}

		System.out.println();
		for (byte b : gbk) {
			// GBK 编码中中文占用2个字节
			System.out.print(Integer.toHexString(b & 0xff) + " ");// 16进制显示
		}
	}

	public static void binaryCount() throws Exception {
		System.out.println();
		// 问题，以下数字与字符串比较，哪边占有空间较多(字节)
		// 第一组：123 "123" [32 > 8*3]
		// 第二组：1234 "1234" [32 = 8*4]
		// 第三组：12345 "1234" [32 < 8*5]
		// 答：int数字统一占32-bit,而字符串需先转为byte,每个byte占8-bit。
		// 标注: 1byte=8-bit.显示32位的原因是此函数将byte当作int处理，1int=32-bit

		System.out.println(to32(Integer.toBinaryString(123))); // 二进制长度32
		System.out.println(to32(Integer.toBinaryString(12345)));// 二进制长度32

		// 二进制长度8*3 = 24
		for (byte b : "123".getBytes("gbk")) {
			System.out.print(to8(Integer.toBinaryString(b)) + " ");
		}

		// 二进制长度8*4 = 32
		System.out.println();
		for (byte b : "1234".getBytes("gbk")) {
			System.out.print(to8(Integer.toBinaryString(b)) + " ");
		}
	}

	public static void main(String[] args) throws Exception {

		// bitLength();
		bitCompute_imooc();

//		 bitCompute();
//		bitCompute32();
		// binaryCount();
	}

}

/**
 * `文件的编码-慕课网`
 * http://www.imooc.com/video/1832
 */