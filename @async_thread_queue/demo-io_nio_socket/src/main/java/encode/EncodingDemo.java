package encode;

import java.io.*;
import java.nio.charset.Charset;

public class EncodingDemo {
//    private static final Logger logger = LogFactory.getDebugLog(EncodingDemo.class);

    /**
     * 对字符串重新编码
     *
     * @param text        字符串
     * @param resEncoding 源编码
     * @return 重新编码后的字符串
     */
    public static String showEncoding(String text, String resEncoding) {
        String rs = null;
        try {
            rs = new String(text.getBytes(), resEncoding);
        } catch (UnsupportedEncodingException e) {
            // logger.error("读取文件为一个内存字符串失败，失败原因是使用了不支持的字符编码");
            throw new RuntimeException(e);
        }
        return rs;
    }

    /**
     * 对字符串重新编码
     *
     * @param text        字符串
     * @param resEncoding 源编码
     * @param newEncoding 新编码
     * @return 重新编码后的字符串
     */
    public static String reEncoding(String text, String resEncoding, String newEncoding) {
        String rs = null;
        try {
            rs = new String(text.getBytes(resEncoding), newEncoding);
        } catch (UnsupportedEncodingException e) {
            // logger.error("读取文件为一个内存字符串失败，失败原因是使用了不支持的字符编码");
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static String getEncoding(String str) throws UnsupportedEncodingException {

        String encode = "GB2312";
        if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GB2312
            return encode;//是的话，返回“GB2312“，以下代码同理
        }

        encode = "ISO-8859-1";
        if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是ISO-8859-1
            String s1 = encode;
            return s1;
        }

        encode = "UTF-8";
        if (str.equals(new String(str.getBytes(encode), encode))) {   //判断是不是UTF-8
            String s2 = encode;
            return s2;
        }

        encode = "GBK";
        if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GBK
            String s3 = encode;
            return s3;
        }

        return "";
    }


    /**
     * 常规转码示例 <功能详细描述> [参数说明]
     *
     * @return void [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void encoding() {
        /**
         * <pre> 乱码的由来
         * 在所有的流操作里。字节永远是最基础的。任何基于字节的操作都是正确的。无论你是文本文件还是二进制的文件。
         * 如果确认流里面只有可打印的字符，包括英文的和各种国家的文字，也包括中文，那么可以考虑用字符流。
         * 由于编码不同，多字节的字符可能占用多个字节。比如GBK的汉字就占用2个字节，而UTF-8的汉字就占用3个字节。
         * 所以，字符流是根据指定的编码，将1个或多个字节转化为java里面的unicode的字符，然后进行操作。
         * 字符操作一般使用Writer,Reader等， 字节操作一般都是InputStream, OutputStream 以及各种包装类，比如BufferedInputStream和BufferedOutputStream等。
         * 总结：如果你确认你要处理的流是可打印的字符，那么使用字符流会看上去简单一点。如果不确认，那么用字节流总是不会错的。
         * </pre>
         */

        try {
            // 文件转码
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(""), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(""), "UTF-8"));

            // servlet,网络转码
            String message_I = java.net.URLEncoder.encode("message", "UTF-8");// 转码
            String message_O = java.net.URLDecoder.decode("message", "utf-8");// 解码
            // response.setCharacterEncoding("UTF-8");

            // Html编码
            String htmlCoding = "<body><head>...<META http-equiv=Content-Type content='text/html; charset=utf-8' /><META content='MSHTML 6.00.6000.16788' name=GENERATOR /></head><body>";

            // XML
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("当前环境默认编码:" + Charset.defaultCharset());// 当前环境默认编码

        System.out.println(getEncoding("你好"));
        System.out.println(new String("你好".getBytes(getEncoding("你好")), getEncoding("你好")));

        System.out.println("双转码,异常:");
        System.out.println(reEncoding("你好", "ISO-8859-1", "UTF-8"));
        System.out.println(reEncoding("你好", "UTF-8", "ISO-8859-1"));
        System.out.println(reEncoding("你好", "gbk", "UTF-8"));
        System.out.println(reEncoding("你好", "UTF-8", "gbk"));
    }
}
