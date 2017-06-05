package question;

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

    private final static String URL_PREFIX = "http://www.zybang.com/question/";

    private final static String CSV_NAME = "question-data.csv";
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
        cw.write("result");
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

        if (FILTERS.matcher(href).matches() || !href.startsWith(URL_PREFIX)) {
            return false;
        }

        String[] strs = href.split("\\?");
        if (strs.length < 2) {
            return false;
        }

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

            String title = doc.select(".qb-content").first().text();
            String result = doc.select("#good-answer > dd > span").first().text();

            try {
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(csv, true), "UTF-8");
                cw = new CsvWriter(osw, ',');
                cw.write(title);
                cw.write(result);
                cw.endRecord();
                cw.close();
                System.out.println("成功写入一条记录！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}