package content;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AnnotationSpring {

    @Bean
    BeanTest mockAnnotationSpring() {
        return new BeanTest();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationSpring.class);
        BeanTest beanTest = context.getBean(BeanTest.class);// spring中获取Bean
        beanTest.sayHello();// hello
    }
}

class BeanTest {
    void sayHello() {
        System.out.println("hello");
    }
}