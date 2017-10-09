package content;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;

public class SpringContextDWebDemo extends HttpServlet {

    void context(){
        ApplicationContext applicationContext;

        /* web应用初始化Spring上下文 */
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    }

    public static void main(String[] args) {

        new SpringContextDWebDemo().context();

    }
}
