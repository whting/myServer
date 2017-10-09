package my.liuxiang.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiang on 2017/8/21.
 */
@RestController
@RequestMapping("/rest/demo")
public class HelloRestContoller {

    /**
     * http://localhost:8080/demo/hello
     */
    @RequestMapping("/hello")
    public HelloDo hello(){
        System.out.println("hello world");
        HelloDo helloDo = new HelloDo();
        helloDo.setName("hello world");
        return helloDo;
    }
}
