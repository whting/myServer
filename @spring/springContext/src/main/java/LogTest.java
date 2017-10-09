import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test {
    private static Log log = LogFactory.getLog(Test.class);

    public void log(){
       log.debug("Debug info.");
       log.info("Info info");
       log.warn("Warn info");
       log.error("Error info");
       log.fatal("Fatal info");
    }

    public static void main(String[] args) {
       Test test = new Test();
       test.log();
    }
}