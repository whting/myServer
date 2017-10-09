import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class Test {

    public static String to32(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result.append("1");
            } else {
                result.append("0");
            }
            if ((32 - i) % 8 == 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    static void bitTest() {

        HashMap hashMap = new HashMap();
        for (int i = 0; i < 50; i++) {
            int kv = (int) (Math.random() * 10000);
            System.out.println(i + " " + kv);
            hashMap.put(kv, kv);
        }

        //Integer i=100;
        //int ihc =i.hashCode();
        //System.out.println(ihc);
        //System.out.println((ihc>>>16) ^ ihc);// 仅会影响到高16位存在数值的对象 作用：jdk的hashCode算法原因,有可能存在大量对象hashcode的变化体现在高16位,而低16位相对稳定,如此会造成hash表分配的不均匀

        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toBinaryString(i));
        }

        Integer i = 100;
        int ihc = i.hashCode();
        System.out.println("            " + Integer.toBinaryString(ihc));// 1100100
        System.out.println("hash表分配(15):" + Integer.toBinaryString(15) + " " + (ihc & 15) + " " + Integer.toBinaryString((ihc & 15)));    // hash表分配(15):1111 4 100
        System.out.println("resize分配(16):" + Integer.toBinaryString(16) + " " + (ihc & 16) + " " + Integer.toBinaryString((ihc & 16)));// resize分配(16):10000 0 0
        System.out.println("hash表分配(31):" + Integer.toBinaryString(31) + " " + (ihc & 31) + " " + Integer.toBinaryString((ihc & 31)));// hash表分配(31):11111 4 100
        System.out.println("resize分配(32):" + Integer.toBinaryString(32) + " " + (ihc & 32) + " " + Integer.toBinaryString((ihc & 32)));// resize分配(32):100000 32 100000
        System.out.println("resize分配(63):" + Integer.toBinaryString(63) + " " + (ihc & 63) + " " + Integer.toBinaryString((ihc & 63)));// resize分配(63):111111 36 100100
        System.out.println("resize分配(64):" + Integer.toBinaryString(64) + " " + (ihc & 64) + " " + Integer.toBinaryString((ihc & 64)));// resize分配(64):1000000 64 1000000
        System.out.println("resize分配(127):" + Integer.toBinaryString(127) + " " + (ihc & 127) + " " + Integer.toBinaryString((ihc & 127)));// resize分配(127):1111111 100 1100100
        System.out.println("resize分配(128):" + Integer.toBinaryString(128) + " " + (ihc & 128) + " " + Integer.toBinaryString((ihc & 128)));// resize分配(128):10000000 0 0
        System.out.println("resize分配(255):" + Integer.toBinaryString(255) + " " + (ihc & 255) + " " + Integer.toBinaryString((ihc & 255)));// resize分配(255):11111111 100 1100100
        System.out.println("resize分配(256):" + Integer.toBinaryString(256) + " " + (ihc & 256) + " " + Integer.toBinaryString((ihc & 256)));// resize分配(256):100000000 0 0
        System.out.println();
    }



    public static void main(String[] args) {

    }
}