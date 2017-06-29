
package com.fengjx.dubbo.service;

/**
 *
 *
 * @author fengjx.
 * @date：2015/1/6 0006
 */
public class HelloServiceConsumer {

    private HelloService helloService;

    public String helloFjx(){
//        return "Hello fengjx";
        return helloService.sayHello("fengjx");
    }



    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
