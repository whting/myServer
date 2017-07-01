package pool;

/**
 * 诊断信息接口
 *
 * @author liqiang
 */
public interface ThreadPoolDiagnose {

    public boolean running();

    public int maxsize();

    public int size();

//    public ThreadDiagnose[] getDiagnose();

}
