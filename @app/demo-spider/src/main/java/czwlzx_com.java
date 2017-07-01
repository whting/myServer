import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/11
 */
public class czwlzx_com {

    /**
     * 抓取
     *
     * @throws IOException
     */
    public void collect() throws IOException {
        String url = "http://www.czwlzx.com/stzx/29774.html";

        Document document = Jsoup.connect(url).get();
        Elements links = document.select("#fontzoom a");
        for (Element c : links) {
            String href = c.attr("href");
//            System.out.println("http://www.czwlzx.com"+href);

            try {
                Thread.sleep(100);// 睡眠,避免被反爬虫
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                String hrefUrl = href.indexOf("czwlzx") > 0 ? href : "http://www.czwlzx.com" + href;
                Document document2 = Jsoup.connect(hrefUrl).get();
                Elements download = document2.select("#fontzoom a");
                Elements title = document2.select(".main_ArticleTitle font");

                System.out.print(title.html() + "  ");
                System.out.println("http://www.czwlzx.com/" + download.attr("href"));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        czwlzx_com home = new czwlzx_com();
        home.collect();
    }
}
