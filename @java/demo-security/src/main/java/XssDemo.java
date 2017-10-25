import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

public class XssDemo {
    public static void main(String[] args) {
        System.out.println(StringEscapeUtils.escapeHtml("<img></img>"));// &lt;img&gt;&lt;/img&gt;
        System.out.println(StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml("<img></img>")));// <img></img>

        System.out.println(HtmlUtils.htmlEscape("<img></img>"));// &lt;img&gt;&lt;/img&gt;
        System.out.println(HtmlUtils.htmlUnescape(StringEscapeUtils.escapeHtml("<img></img>")));// <img></img>

        // 风险
        System.out.println("------------------风险:{\"key\":\"<img></img>\"}");
        System.out.println(HtmlUtils.htmlEscape("{\"key\":\"<img></img>\"}") + " 双引号也被替换,将导致json无法解析");

        System.out.println("------------------应对");
        JSONObject jsonObject = (JSONObject) JSONObject.parse("{\"key\":\"<img></img>\"}");
        for (Map.Entry entry : jsonObject.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());// key:<img></img>
            System.out.println(entry.getKey() + ":" + HtmlUtils.htmlEscape((String) entry.getValue()));// key:&lt;img&gt;&lt;/img&gt;
        }
        System.out.println("------------------修复");
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            if(entry.getValue() instanceof String) {
                entry.setValue(HtmlUtils.htmlEscape((String) entry.getValue()));
            }
        }
        System.out.println(jsonObject.toJSONString());// {"key":"&lt;img&gt;&lt;/img&gt;"}
    }
}
