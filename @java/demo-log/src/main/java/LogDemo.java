import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogDemo {
    private static Log log = LogFactory.getLog(LogDemo.class);

    public void log(){
       log.debug("Debug info.");
       log.info("Info info");
       log.warn("Warn info");
       log.error("Error info");
       log.fatal("Fatal info");
    }

    public static void main(String[] args) {
       LogDemo test = new LogDemo();
       test.log();
    }
}

/**
 * 如果项目的classpath中包含了log4j的类库，就会使用log4j，否则就使用JDK Logging。
 * 加载顺序:log4j>jdkLog(无debug级别)
 * 参考:http://blog.csdn.net/u011794238/article/details/50747953
 */
/**
 * 修改级别:
 * 方案一:通过commons-logging.properties设置.
 *  先新增commons-logging.properties设置log-Impl. 如:SimpleLog (默认级别是:Info)
 *  再依据logImpl设置log-lever. 如:defaultlog=debug
 *
 * 方案二:使用lo4j.
 * 前置条件:需要依赖外部包`log4j:log4j:1.2.17`
 *
 * ﻿参考:http://zhangjunhd.blog.51cto.com/113473/25135/
 */