import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathAccuracy {

    /**
     * Java浮点数计算精度问题总结
     * http://www.jianshu.com/p/1d6ba0047a5b
     * <p>
     * 为什么1.0 - 0.7 != 0.3????? - jiqikewang的专栏 - CSDN博客
     * http://blog.csdn.net/jiqikewang/article/details/7031738
     */
    static void demo() {
        System.out.println(0.1 + 0.2);  //输出：0.30000000000000004
        System.out.println(1.1 + 1.2);  //输出：2.3
        System.out.println(0.1f + 0.2f);//输出：0.3

        /**
         * 浮点数计算可能出问题的根本原因：
         * IEEE754的浮点数世界里，0.1(单精度或双精度浮点数)并不是真正的0.1，0.2(单精度或双精度浮点数)也并不是真正的0.2，所以相加的值并不完全等于0.3。
         */
    }

    /**
     * 浮点数精度
     */
    static void floatDubleAccuracy() {
        Integer i = 2147483647 + 1;
        System.out.printf("[%s] %s", i.getClass(), i).println();

        Float f = 2147483647f, f2 = 999.0001f, f3 = 999.00001f;// 支持到后4位精度
        System.out.printf("[%s] %s", f.getClass(), f).println();
        System.out.printf("[%s] %s", f2.getClass(), f2).println();
        System.out.printf("%s] %s", f3.getClass(), f3).println();

        Double d = 2147483647d, d2 = 999.0000000000001d, d3 = 999.00000000000001d;// 支持到后13位精度
        System.out.printf("[%s] %s", d.getClass(), d).println();
        System.out.printf("[%s] %s", d2.getClass(), d2).println();
        System.out.printf("[%s] %s", d3.getClass(), d3).println();

        BigDecimal bigDecimal = new BigDecimal("999.0000000000000000000000000000000001");// 最高精度
        System.out.printf("[%s] %s", bigDecimal.getClass(), bigDecimal).println();
        System.out.println(bigDecimal.add(new BigDecimal("0.1")));// BigDecimal计算 999.1000000000000000000000000000000001
    }

    /**
     * 高精度二进制
     */
    static void bigDecimal() {
        System.out.println(new BigDecimal(0.1f));// 0.100000001490116119384765625
        System.out.println(new BigDecimal("0.1"));// 0.1
        System.out.println(0.1f);// 0.1

        System.out.println(new BigDecimal(0.2d));
        System.out.println(new BigDecimal(0.1d).add(new BigDecimal(0.1d)));

        System.out.println(new BigDecimal(0.2f));
        System.out.println(new BigDecimal(0.1f).add(new BigDecimal(0.1f)));

        System.out.println(new BigDecimal(0.3d));
        System.out.println(new BigDecimal(0.1d).add(new BigDecimal(0.1d)).add(new BigDecimal(0.1d)));

        System.out.println(new BigDecimal(0.3f));
        System.out.println(new BigDecimal(0.1f).add(new BigDecimal(0.1f)).add(new BigDecimal(0.1)));

        System.out.println("计算：");
        //正确的姿势：
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));//输出：0.3

        //错误的姿势：
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));    //输出：0.3000000000000000166533453693773481063544750213623046875
    }

    /**
     * decimal小数计算
     */
    static void decimalMath() {
        System.out.println(0.1 + 0.2);// 0.30000000000000004
        String decimalNumber = new DecimalFormat("0.00").format(0.1 + 0.2);
        System.out.println(decimalNumber);// 0.30

        System.out.println(new DecimalFormat("#.00").format(96.789d));// 96.79
    }

    public static void main(String[] args) {

//        demo();
//        floatDubleAccuracy();

//        bigDecimal();
        decimalMath();
    }
}

/**
 * `Java中对象的类型判断 - ShiKangkai's BLOG - CSDN博客`
 * http://blog.csdn.net/shikangkai/article/details/50273527
 */