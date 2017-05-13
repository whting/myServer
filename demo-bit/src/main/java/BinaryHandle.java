
import java.io.UnsupportedEncodingException;

/**
 * 进制处理
 *
 * @author liuxiang
 */
public class BinaryHandle {

    public static void main(String[] args) throws UnsupportedEncodingException {

        int in = 100;
        String binStr = Integer.toBinaryString(in);// 二进制
        String otcStr = Integer.toOctalString(in); // 八进制
        String hexStr = Integer.toHexString(in);   // 十六进制
        System.out.println(binStr);
        System.out.println(otcStr);
        System.out.println(hexStr);

        System.out.println("------------");

        System.out.println(Integer.toBinaryString(5));

        System.out.println("------------");

        // 注意: 1byte=8-bit.显示32位的原因是此函数将byte当作int处理，1int=32-bit

        String s = "慕课ABC";
        byte[] utf8 = s.getBytes("utf-8");
        for (byte b : utf8) {
            // UTF-8 编码中中文占用3个字节
            System.out.print(Integer.toBinaryString(b & 0xff) + " ");
        }

        System.out.println();
        byte[] gbk = s.getBytes("gbk");
        for (byte b : gbk) {
            // GBK 编码中中文占用2个字节
            System.out.print(Integer.toBinaryString(b & 0xff) + " ");
        }

        System.out.println();
        System.out.println(Integer.toBinaryString(0xff));// 二进制位11111111
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }
}