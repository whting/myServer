package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 用@Configuration注解该类，等价 与XML中配置beans；用@Bean标注方法等价于XML中配置bean
@ComponentScan
public class Application {

    // private final static Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * 通过@Bean初始化此实例,并在MessagePrinter类中@Autowired,自动注入
     *
     * @return
     */
    @Bean
    MessageService mockMessageService() {

        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}

