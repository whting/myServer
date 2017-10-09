package content;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class SpringContextWebDemo extends HttpServlet {

    void webContext() {
        ApplicationContext applicationContext;

        /* web应用初始化Spring上下文 */
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    }

    static void context() {
        ApplicationContext applicationContext;

        /** 非web应用初始化Spring上下文 */
        // FileSystemXmlApplicationContext 文件路径
        applicationContext = new FileSystemXmlApplicationContext();// 我自定义配置
        applicationContext = new FileSystemXmlApplicationContext("applicationContext.xml");// 默认寻址路径:WebRoot/WEB-INF/ 或 当前路径
        applicationContext = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
        applicationContext = new FileSystemXmlApplicationContext(new String[]{"WebRoot/WEB-INF/applicationContext.xml"});// 数组
        applicationContext = new FileSystemXmlApplicationContext("classpath*:spring/spring-context*.xml");// classpath相对路径

        // ClassPathXmlApplicationContext 容器会从 CLASSPATH 中搜索 bean 配置
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    static void annotationContext(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
    }

    public static void main(String[] args) {
        new SpringContextWebDemo().webContext();
        context();
    }
}

/**
 * 手动获取spring的ApplicationContext和bean对象 - 自行车上的程序员 - 博客园
 * http://www.cnblogs.com/yangzhilong/p/3949332.html
 * <p>
 * Spring ApplicationContext 容器 - Spring 教程 - 极客学院Wiki
 * http://wiki.jikexueyuan.com/project/spring/ioc-container/spring-application-context-container.html
 */