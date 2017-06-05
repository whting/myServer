import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static javafx.beans.binding.Bindings.select;
import static javax.management.Query.attr;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Home {

    String rootFolder = "F:\\Work\\tuiku_html\\";

    private Map<String, String> cookies;

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    /**
     * 登录
     *
     * @throws IOException
     */
    public void login() throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("utf8", "✓");
        map.put("email", "liuxiang.1227@qq.com");
        map.put("password", "tuicool");

        Connection.Response response = Jsoup.connect("http://www.tuicool.com/login")
                .data(map)
                .method(Connection.Method.POST)
                .execute();

        System.out.println("statusCode:" + response.statusCode());

        if (response.statusCode() == 200) {
            setCookies(response.cookies());
            System.out.println("cookies:" + response.cookies());
        }
    }

    /**
     * 收藏
     *
     * @throws IOException
     */
    public void collect() throws IOException {
        String url = "http://www.tuicool.com/articles/my?pn=";
        for (int i = 0; i < 5; i++) {
            Document document = Jsoup.connect(url + i)
                    .cookies(getCookies())
                    .get();

            System.out.println("\n" + url + i);// 显示当前页地址

            /* 到头中断 */
            Elements end = document.select(".user-empty-tip");
            if (end.size() > 0) {
                return;
            }

            Elements content = document.select("body > div.container-fluid > div.row-fluid > div.span9.container-body > div:nth-child(2)");
            Elements links = content.select(".single_simple");
            for (Element c : links) {
                String title = c.select(".title").first().text().replaceAll("<", "&lt;");
                String href = c.select(".title > a").first().attr("href");
                String date = c.select(".date").first().text();

                /* 打印数据 */
                System.out.println(title + "   " + "http://www.tuicool.com" + href + "   " + date);

                /** 具体也没访问 */
                singleSent(date, title, "http://www.tuicool.com/" + href);
            }
        }
    }

    public void folderInit() {
        File folder = new File(rootFolder);
        if (!new File(rootFolder).exists()) {
            folder.mkdirs();
        }
    }

    public void singleSent(String date, String title, String url) throws IOException {

        String fileName = date + "_" + title;
        fileName = fileName.replaceAll("[\\/:*?\"<>|]", "").replace("\b","");
        File singleFile = new File(rootFolder + fileName + ".html");
        if (!singleFile.exists()) {

            try {
                Thread.sleep(1000);// 睡眠,避免被反爬虫
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 不存在再请求,创建
            Document doc = Jsoup.connect(url).cookies(getCookies()).get();
//            System.out.println("========== new File:" + rootFolder + fileName + ".html");
            saveFile(rootFolder + fileName + ".html", doc.toString());
        }
    }

    /**
     * 保存文件
     */
    public void saveFile(String filePath, String content) throws IOException {
        File singleFile = new File(filePath);
        FileWriter fw = new FileWriter(singleFile);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(content);
        bfw.flush();
        bfw.close();
    }

    public static void main(String[] args) throws IOException {
        Home home = new Home();
        home.folderInit();
        home.login();
        home.collect();

        /* 单文件测试 */
        // home.singleSent("2016-07-18","http://www.tuicool.com/articles/Zjua2mj");
    }

}
//  System.out.println("1234567".replaceAll("[246]","-"));
//  System.out.println("07-16 16:57_CSS设计模式：OOCSS 和 SMACSS - 推酷".replaceAll("[\\/:*?\"<>|]",""));
//  System.out.println("07-16 16:57_CSS设计模式：OOCSS 和 SMACSS - 推酷".replaceAll("[\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]", ""));
//  String temp = " abc  :?das*-b<>b.txt";
//  System.out.println(temp.replaceAll("[\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]", ""));
