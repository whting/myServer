package crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.authentication.AuthInfo;
import edu.uci.ics.crawler4j.crawler.authentication.FormAuthInfo;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Controller {
    public static void main(String[] args) throws Exception {
        String rootFolder = "C:\\Users\\Administrator\\Desktop\\crawl";
        int numberOfCrawlers = 1;
        String storageFolder = rootFolder + "/csv/";
        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(rootFolder);

        config.setMaxPagesToFetch(1000);
        config.setIncludeBinaryContentInCrawling(false);

        String formUsername = "email";
        String formPassword = "password";
        String session_user = "liuxiang.1227@qq.com";
        String session_password = "tuicool";
        String urlLogin = "http://www.tuicool.com/login";
        AuthInfo formAuthInfo = new FormAuthInfo(session_password, session_user, urlLogin, formUsername, formPassword);
        config.addAuthInfo(formAuthInfo);// 没达到登录效果
        config.setMaxDepthOfCrawling(0);

        String[] crawlDomains = {"http://www.tuicool.com/articles/my?pn=0"};

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        for (String domain : crawlDomains) {
            controller.addSeed(domain);
        }

        MyCrawler.configure(crawlDomains, storageFolder);
        controller.start(MyCrawler.class, numberOfCrawlers);
//        controller.shutdown();
    }
}
