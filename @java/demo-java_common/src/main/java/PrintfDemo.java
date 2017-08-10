import java.util.Date;

/**
 * @author liuxiang on 2017/8/10.
 */
public class PrintfDemo {

    public static void main(String[] args) {
        System.out.printf("%s = %s %n", "Name", "Zhangsan");  // 参数模板绑定并换行
        System.out.printf("%d; %d; %n", -500, 2343L); // 数字
        System.out.printf("%e; %e; %e %n", -756.403f, 7464.232641d, 45.6d); // 浮点数

        System.out.printf("%1$ty-%1$tm-%1$td; %2$ty-%2$tm-%2$td %n", new Date(), new Date().getTime()); // 17-08-10; 17-08-10
        System.out.printf("%1$tY-%1$tB-%1$td; %2$tY-%2$tb-%2$td %n", new Date(), new Date().getTime()); // 2017-八月-10; 2017-八月-10
        System.out.printf("%1$tY-%1$tm-%1$td; %2$tY-%2$tm-%2$td %n", new Date(), new Date().getTime()); // 2017-08-10; 2017-08-10
    }
}

/**
 * ﻿
 * `java 利用printf格式化输出 - 蜕变中的Programmer - CSDN博客`
 * http://blog.csdn.net/lidekun9132/article/details/52846983
 */