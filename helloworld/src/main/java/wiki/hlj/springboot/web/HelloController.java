package wiki.hlj.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld服务
 * Created by HLJ on 2017/7/4 16:46.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "HELLO, WORLD!!!";
    }

}
