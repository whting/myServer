package demo;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Set;
import java.util.regex.Pattern;

import static javafx.beans.binding.Bindings.select;

/**
 * Created by Administrator on 2016/7/6.
 */
public class MyCrawler extends WebCrawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp3|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches();
//        return !FILTERS.matcher(href).matches() && href.startsWith("http://www.zybang.com/question");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL:" + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            System.out.println("Text length:" + text.length());
            System.out.println("Html lenght:" + html.length());
            System.out.println("Number of outgoing links:"+links.size());

            /** 解析内容 **/
            Document doc = Jsoup.parse(html);
            String title = doc.select("body > div.layout.main-body > div.main-con > dl > dd > span").first().text();
            String resolve = doc.select("#good-answer > dd > span").first().text();

            System.out.println("title:"+title);
            System.out.println("resolve:"+resolve);

        }
    }
}
