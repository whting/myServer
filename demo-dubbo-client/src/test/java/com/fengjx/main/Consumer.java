
package com.fengjx.main;

import com.fengjx.dubbo.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
            "spring.xml"
        });
        context.start();
        // 获取远程服务代理
        HelloService helloService = (HelloService) context.getBean("helloService");
        String hello = helloService.sayHello("world"); // 执行远程方法

        System.out.println("==================== "+hello); // 显示调用结果
    }

}
