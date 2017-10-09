import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuxiang on 2017/8/7.
 */
public class SqlAutoParamters {

    public static void main(String[] args) throws NoSuchMethodException {

        // TODO 待java多行字符串方法优化,去除繁杂的字符串加工
        String autoParameters = "" +
                "***";
        // System.out.println(autoParameters);

        // 多sql
        showSqlAll(autoParameters);

        // 单sql
//        String sql = autoParaminding(autoParameters);
//        System.out.println(sql);
    }

    static void showSqlAll(String autoParameters) {
        String[] aps = autoParameters.split("<==      Total");
        for (int i = 0; i < aps.length - 1; i++) {
            String sql = autoParaminding(aps[i]);
            System.out.println(sql);
        }
    }

    static String autoParaminding(String autoParameters) {

        int preparingBegin = autoParameters.indexOf("Preparing: ") + 11;
        int preparingend = autoParameters.indexOf("\n", preparingBegin);
        String preparing = autoParameters.substring(preparingBegin, preparingend);
//        System.out.println(preparing);// 动态参数Sql

        int parametersBegin = autoParameters.indexOf("Parameters: ") + 12;
        int parametersEnd = autoParameters.indexOf("\n", parametersBegin);
        String parameters = autoParameters.substring(parametersBegin, parametersEnd);
//        System.out.println(parameters);// 动态参数

        return showSql(preparing, parameters);// show
    }

    static String showSql(String preparing, String parameters) {
        String[] ps = parameters.split(",");
        int i = 0;
        while (preparing.indexOf("?") != -1) {

//            System.out.println(ps[i]);
            String p = ps[i].split("\\(")[0].trim();
            if (ps[i].contains("String")) {
                preparing = preparing.replaceFirst("\\?", "'" + p + "'");// 字符串补单引号
            } else {
                preparing = preparing.replaceFirst("\\?", p);
            }
            i++;
        }

//        System.out.println(preparing);
        return preparing + ";";
    }

    /**
     * 拆解具体参数值(丢失了数据类型,暂不好用)
     *
     * @param parameters
     * @return
     */
    static Queue<String> parameter2List(String parameters) {
        String[] ps = parameters.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (String str : ps) {
            String p = str.split("\\(")[0];
            queue.offer(p);//追加元素
        }
        return queue;
    }
}