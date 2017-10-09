
package com.fengjx.dubbo.service.impl;

import com.fengjx.dubbo.service.HelloService;

/**
 * @author fengjx.
 * @date：2015/1/6 0006
 */
public class HelloServiceImpl implements HelloService {


    /**
     * 暴露的接口
     *
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {
        System.out.println("call sayHello");
        return "Hello " + name;
    }
}
