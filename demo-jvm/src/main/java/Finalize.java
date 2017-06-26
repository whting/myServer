/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class Finalize {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(FinalizedEscapeTestCase.caseForEscape);
        FinalizedEscapeTestCase.caseForEscape = new FinalizedEscapeTestCase();
        System.out.println(FinalizedEscapeTestCase.caseForEscape);// FinalizedEscapeTestCase@14ae5a5
        FinalizedEscapeTestCase.caseForEscape = null;
        System.out.println(FinalizedEscapeTestCase.caseForEscape);// null
        System.gc();
        Thread.sleep(100);
        System.out.println(FinalizedEscapeTestCase.caseForEscape);// FinalizedEscapeTestCase@14ae5a5
    }
}

class FinalizedEscapeTestCase {

    public static FinalizedEscapeTestCase caseForEscape = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("哈哈，我已逃逸！");
        caseForEscape = this;//
    }
}

/**
 * 深入理解JVM--JVM垃圾回收机制 - jbutton - ITeye技术网站
 * http://jbutton.iteye.com/blog/1569746
 */

