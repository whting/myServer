import java.io.PrintStream;

public class ConsoleLink {
    //输入到文件  
    private static final String OUTPUT_TYPE_FILE = "file";
    //输出到控制台  
    private static final String OUTPUT_TYPE_CONSOLE = "console";
    //输出到控制台位置  
    private static final PrintStream OUT;
    private static final PrintStream ERR;

    static {
        OUT = System.out;
        ERR = System.err;
        try {
            //日志输出路径  
//            System.setOut(new PrintStream(new File(System.getProperty("user.dir")+"\\TestLog.TestLog")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义日志的输出路径
     */
    public static void test0() {
        System.out.println("自定义日志的输出测试");
        System.out.println("自定义日志的输出路径");
    }

    /**
     * 输出日志到控制台
     */
    public static void test1() {
        OUT.println("我输出到控制台");
    }

    /**
     * 根据日志输出位置输出日志
     */
    public static void test2(String type) {
        if (OUTPUT_TYPE_FILE.equals(type)) {
            System.out.println("根据日志输出位置输出日志");
        } else if (OUTPUT_TYPE_CONSOLE.equals(type)) {
            OUT.println("根据日志输出位置输出日志");
        }
    }

    /**
     * 输出到控制台并且字体为红色
     */
    public static void test3() {
        ERR.println("输出到控制台并且字体为红色");
    }

    /**
     * 输出到控制台加追踪记录(追踪元素)
     */
    public static void test4() {

        StackTraceElement[] traces = new Throwable().getStackTrace();
        for (int i = 0; i < traces.length; i++) {
            ERR.println("" + traces[i]);
        }

    }

    /**
     * http://www.cnblogs.com/davidwang456/p/3836523.html
     */
    public static void test5() {
        // show currentThread StackTrace
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        System.out.println(stes[stes.length - 2]);

        for (StackTraceElement element : stes) {
            System.out.println(element);
        }

        // error StackTrace
        try {
//            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        //测试输出到文件  
        test0();

        //测试输出到控制台
        test1();

        //测试输出目标为控制台和文件
        test2(OUTPUT_TYPE_FILE);
        test2(OUTPUT_TYPE_CONSOLE);

        //输出到控制台并且字体为红色
        test3();

        // 带超链接的日志
        test4();

        System.out.println("====");
        test5();

        System.out.println("===== 手写链接");
        System.out.println("test.ConsoleLink.main(ConsoleLink.java:13)");
        System.out.println("at 'test.ConsoleLink.test5' 1 ");
        System.out.println("at ' test.ConsoleLink#test5 ' 1 ");
        System.out.println("SLF4J: See http://www.slf4j.org/codes.html for an explanation.");
        System.out.println("Error creating bean with name 'cn.fraudmetrix.billing.job.OrderMonitorJob#0' ");
        System.out.println("Error creating bean with name 'ConsoleLink' ");

    }
}

/**
 * `Log4j原理java控制台个性化输出加超链接标记`
 * http://blog.csdn.net/xmtblog/article/details/24362543
 * https://yq.aliyun.com/articles/50596
 */