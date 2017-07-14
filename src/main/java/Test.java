import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class Test {

    /**
     * ORDER_DATE 订单code 时间前缀 ORDER_NUM 订单code 订单初始号
     * [15位时间戳+1000内增长值]
     */
    private static long ORDER_NUM = 01;
    private static String ORDER_DATE;

    // 获取订单code
    public static String getOrderCode() {
        String str = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
        if (ORDER_DATE == null || !ORDER_DATE.equals(str)) {
            ORDER_DATE = str;
            ORDER_NUM = 01;
        }
        ORDER_NUM++;
        long orderNo = Long.parseLong((ORDER_DATE)) * 10000;// 固定长度
        orderNo += ORDER_NUM;
        return orderNo + "";
    }

    public static void main(String args[]) {
        for (int i=0;i<100;i++){
            System.out.println("work"+getOrderCode());
        }
    }
}