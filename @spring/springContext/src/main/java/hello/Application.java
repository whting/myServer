package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {


    MessageService mockMessageServiceNotBean() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {

//        ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext();

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}

