# 目标站(作业帮)使用了反爬虫,默认的请求方式无法获取到数据

```
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.zybang.com/question/3c7e13a3def5a574f195c1c9fb422ce5.html").get();
        System.out.println(doc.outerHtml());
        /*
         <html>
         <head></head>
         <body></body>
         </html>
         */
    }
```