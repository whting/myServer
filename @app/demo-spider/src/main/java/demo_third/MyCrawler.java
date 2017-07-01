package demo_third;

import com.csvreader.CsvWriter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.regex.Pattern;

public class MyCrawler extends WebCrawler {

    private final static Pattern FILTERS = Pattern
            .compile(".*(\\.(css|js|bmp|gif|jpe?g|ico"
                    + "|png|tiff?|mid|mp2|mp3|mp4"
                    + "|wav|avi|mov|mpeg|ram|m4v|pdf"
                    + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    private final static String URL_PREFIX = "http://www.souche.com/pages/onsale/sale_car_list.html?";
    private final static Pattern URL_PARAMS_PATTERN = Pattern.compile("carbrand=brand-\\d+(&index=\\d+)?");

    private final static String CSV_NAME = "data.csv";
    private CsvWriter cw;
    private File csv;

    private static File storageFolder;
    private static String[] crawlDomains;

    public static void configure(String[] domain, String storageFolderName) {
        crawlDomains = domain;

        storageFolder = new File(storageFolderName);
        if (!storageFolder.exists()) {
            storageFolder.mkdirs();
        }
    }

    public MyCrawler() throws IOException {
        String csvPath = storageFolder.getAbsolutePath() + "/" + CSV_NAME;
        csv = new File(csvPath);
        if (csv.isFile()) {
            csv.delete();
        }
        cw = new CsvWriter(new FileWriter(csv, true), ',');
        cw.write("title");
        cw.write("brand");
        cw.write("newPrice");
        cw.write("oldPrice");
        cw.write("mileage");
        cw.write("age");
        cw.write("stage");
        cw.endRecord();
        cw.close();
    }


    /**
     * You should implement this function to specify whether the given url
     * should be crawled or not (based on your crawling logic).
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        System.out.println("href:" + href);
        if(href.startsWith("http://www.souche.com/pages/onsale/sale_car_list.html?")){
            System.out.println("href sale_car_list:" + href);
        }

        if (FILTERS.matcher(href).matches() || !href.startsWith(URL_PREFIX)) {
            return false;
        }

        String[] strs = href.split("\\?");
        if (strs.length < 2) {
            return false;
        }

//        if (!URL_PARAMS_PATTERN.matcher(strs[1]).matches()) {
//            return false;
//        }

        System.out.printf(" => True");
        return true;
    }

    /**
     * This function is called when a page is fetched and ready to be processed
     * by your program.
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();

        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();

            Document doc = Jsoup.parse(html);
            Elements content = doc.select(".card-box.clearfix.car-wrap");
            Elements links = content.select(".carsItem.carItem");

            for (Element c : links) {
//                Element info = c.select(".carsItem.carItem").first();
                String title = c.select(".car-link").first().text();

                String price = c.select(".price-amount").first().text();

                String mileage = c.select("div.car-info > span:nth-child(1)").first().text();
                String age = c.select("div.car-info > span:nth-child(3)").first().text();
                String home = c.select("div.car-info > span:nth-child(5)").first().text();

                try {

//                    FileWriter fileWriter = new FileWriter(csv, true);
                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(csv, true), "UTF-8");

                    cw = new CsvWriter(osw, ',');
                    cw.write(title);
                    cw.write(price);
                    cw.write(mileage);
                    cw.write(age);
                    cw.write(home);
                    cw.endRecord();
                    cw.close();
                    System.out.println("成功写入一条记录！");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}