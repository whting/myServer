package demo_third;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Controller {
    public static void main(String[] args) throws Exception {
        String rootFolder = "C:\\Users\\Administrator\\Desktop\\crawl";
        int numberOfCrawlers = 7;
        String storageFolder = rootFolder + "/csv/";
        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(rootFolder);

        config.setMaxPagesToFetch(1000);
        config.setIncludeBinaryContentInCrawling(false);

        String[] crawlDomains = {"http://www.souche.com/pages/onsale/sale_car_list.html"};

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        for (String domain : crawlDomains) {
            controller.addSeed(domain);
        }

        MyCrawler.configure(crawlDomains, storageFolder);
        controller.start(MyCrawler.class, numberOfCrawlers);
    }
}
