import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class JavaPath {

    public void getJavaPath() throws URISyntaxException, IOException {

        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getCanonicalPath());//获取标准的路径
        System.out.println(directory.getAbsolutePath());//获取绝对路径

        System.out.println("--------");
        // 获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("--------");
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ClassLoader.getSystemResource("").toURI());
        System.out.println(ClassLoader.getSystemResource("").toURI().getPath());
        System.out.println(ClassLoader.getSystemResource("").getPath());

        System.out.println("--------");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath());
        System.out.println(this.getClass().getClassLoader().getResource("").toURI().getPath());
        System.out.println(this.getClass().getResource("pathtest/weixin_appid.properties"));// null
        System.out.println(new File("weixin_appid.properties").getAbsolutePath());
        System.out.println(new File("pathtest/weixin_appid.properties").getAbsolutePath());
        System.out.println(new File("path1.properties").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }

    public void getWebPath() {
        // servlet
        // System.out.println(request.getSession().getServletContext().getRealPath("/"));
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        JavaPath javaPath = new JavaPath();
        javaPath.getJavaPath();
    }
}

/**
 * 1.jsp中取得路径：
 *
 * 以工程名为TEST为例：
 * (1)得到包含工程名的当前页面全路径：request.getRequestURI()
 * 结果：/TEST/test.jsp
 * (2)得到工程名：request.getContextPath()
 * 结果：/TEST
 * (3)得到当前页面所在目录下全名称：request.getServletPath()
 * 结果：如果页面在jsp目录下 /TEST/jsp/test.jsp
 * (4)得到页面所在服务器的全路径：application.getRealPath("页面.jsp")
 * 结果：D:/resin/webapps/TEST/test.jsp
 * (5)得到页面所在服务器的绝对路径：absPath=new java.io.File(application.getRealPath(request.getRequestURI())).getParent();
 * 结果：D:/resin/webapps/TEST
 * <p>
 * 2.在类中取得路径：
 * <p>
 * (1)类的绝对路径：Class.class.getClass().getResource("/").getPath()
 * 结果：/D:/TEST/WebRoot/WEB-INF/classes/pack/
 * (2)得到工程的路径：System.getProperty("user.dir")
 * 结果：D:/TEST
 * <p>
 * 3.在Servlet中取得路径：
 * <p>
 * (1)得到工程目录：request.getSession().getServletContext().getRealPath("") 参数可具体到包名。
 * 结果：E:/Tomcat/webapps/TEST
 * (2)得到IE地址栏地址：request.getRequestURL()
 * 结果：http://localhost:8080/TEST/test
 * (3)得到相对地址：request.getRequestURI()
 * 结果：/TEST/test
 *
 * http://www.cnblogs.com/franson-2016/p/5728280.html
 */