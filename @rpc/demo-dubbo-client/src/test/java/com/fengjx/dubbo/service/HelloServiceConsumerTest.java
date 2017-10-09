
package com.fengjx.dubbo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * 单元测试
 *
 * @author fengjx.
 * @date：2015/1/6 0006
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class HelloServiceConsumerTest {

    @Autowired
    private HelloServiceConsumer helloServiceConsumer;

    @Test
    public void test(){
        String res = helloServiceConsumer.helloFjx();
        System.out.println(res);
        assertEquals("Hello fengjx",res);
    }


}
