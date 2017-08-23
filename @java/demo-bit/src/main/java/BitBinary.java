/**
 * @author liuxiang on 2017/7/28.
 */
public class BitBinary {

    static void bitBinary() {
        // 高位补零
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(~0));
        System.out.println(Integer.toBinaryString(~0 & 1));// 32位高位补零(前置0会自动转int丢失)
        System.out.println(0 + Integer.toBinaryString(((1 << 0x1F) ^ 1)).substring(1));// 32位高位补零

        // 10进制的二进制表现
        System.out.println(0x08 == 8);// true
        System.out.println(0x09 == 9);// true
        System.out.println(0x0A == 10);// true
        System.out.println(0x1f == 31);// true
        System.out.println(0xff == 0xFF && 0xFF == 255);// true

        System.out.println(Integer.toBinaryString(0xFF));// 11111111 作用:1byte=8位,多余的前缀都是无效的. 通过[& 0xff]剔除干扰(在byte转二进制时使用)

        // 位移
        System.out.println(Integer.toBinaryString(1 << 0x08));// 100000000
        System.out.println(Integer.toBinaryString(1 << 0x09));// 1000000000
        System.out.println(Integer.toBinaryString(1 << 0x0A));// 10000000000
        System.out.println(Integer.toBinaryString(1 << 31));// 左移31位
        System.out.println(Integer.toBinaryString(1 << 33));// 左移32位(int超过32位[4个字节]位移将循环)

        // 状态位判断(常用于数据的复合状态)
        System.out.println();
        System.out.println(Integer.toBinaryString(~0));// 32位1,用于测试
        System.out.println(Integer.toBinaryString(~0 & (1 << 0x08) >> 0x08));// 第9位[1<<8]是不是1
        System.out.println(Integer.toBinaryString(~0 & (1 << 0x09) >> 0x09));// 第10位[1<<9]是不是1
        System.out.println(Integer.toBinaryString(~0 & (1 << 0x0A) >> 0x0A));// 第11位[1<<10]是不是1
    }

    /**
     * 复合状态(bit)
     */
    static void statusComplex() {


        /* 位或"|",同位其中一个位1,结果及为1 */
        System.out.println(Integer.toBinaryString(1 << 0x08));// 100000000
        int status = 0;
        status = status | (1 << 0x08);// 设置第9位状态
        System.out.println(Integer.toBinaryString(status));// 100000000

        status = status | (1 << 0x0A);// 设置第11位状态
        System.out.println(Integer.toBinaryString(status));// 10100000000

        status = status | (1 << 0x09);// 设置第10位状态
        System.out.println(Integer.toBinaryString(status));// 11100000000


        System.out.println("======================");

        /* 为与"&",同位两个均为1,结果才为1 */
        System.out.println(Integer.toBinaryString(~(1 << 0x08)));// 11111111111111111111111011111111
        status = status & ~(1 << 0x08);// 取消第9位状态
        System.out.println(Integer.toBinaryString(status));// 11000000000

        status = status & ~(1 << 0x0A);// 取消第11位状态
        System.out.println(Integer.toBinaryString(status));// 1000000000

        status = status & ~(1 << 0x09);// 取消第10位状态
        System.out.println(Integer.toBinaryString(status));// 0
    }

    /**
     * 单一状态(enum枚举)
     */
    static void statusSingle() {
        System.out.printf("%s %s", OrderStatus.OPEN, OrderStatus.OPEN.getDisplay());// OPEN 未执行
    }

    public static void main(String[] args) {
        // bitBinary();
        statusComplex();
        // statusSingle();
    }
}

class BitHelper {

    public static int set(final int data, final int mask, final boolean value) {
        if (value) {
            return data | (1 << mask);
        } else {
            return (data & ~(1 << mask));
        }
    }

    public static boolean get(final int data, final int mask) {
        return ((data & (1 << mask)) >> mask) != 0;
    }
}

/**
 * OFFICIAL(0x08, "付费"),
 * TRIAL(0x09, "试用"),
 * FREE(0x0A, "免费");
 * (不是很好的例子,[付费,试用,免费]业务状态互斥,非必要使用二进制位标记状态.如下enum-OrderStatus)
 */

enum OrderStatus {

    //基本状态
    OPEN("未执行"),
    CLOSE("已执行"),
    CANCEL("已取消");

    private String display;

    OrderStatus(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}

/**
 * 订单实体DO,状态字段类型直接使用枚举
 * 数据库字段类型String,值为[OPEN/CLOSE/CANCEL]
 */
class OrderDO {
    /**
     * 订单状态
     */
    private OrderStatus status;
}
/**
 * OrderMapper.xml
 * <p>
 * <mapper namespace="***.OrderDAO">
 * <resultMap id="OrderMap" type="OrderDO">
 * <result property="status" column="status"/>
 * </resultMap>
 * <p>
 * <select id="queryAllByCondition" parameterType="OrderDO" resultMap="OrderMap">
 * SELECT * FROM `order`
 * </select>
 */