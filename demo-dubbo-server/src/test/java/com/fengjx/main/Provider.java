
package com.fengjx.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
            "spring.xml"
        });
        context.start();
        System.out.println("dubbo-server服务正在监听，按任意键退出");
        System.in.read();
    }

}
