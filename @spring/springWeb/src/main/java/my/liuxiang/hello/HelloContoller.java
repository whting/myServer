package my.liuxiang.hello;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxiang on 2017/8/21.
 */
@Controller
@RequestMapping("/demo")
public class HelloContoller {

    /**
     * http://localhost:8080/demo/hello
     */
    @RequestMapping("/hello")
    @ResponseBody
    public HelloDo hello(){
        System.out.println("hello world");
        HelloDo helloDo = new HelloDo();
        helloDo.setName("hello world");
        return helloDo;
    }
}
