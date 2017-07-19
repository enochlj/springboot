package wiki.hlj.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index服务
 * Created by HLJ on 2017/7/4 17:55.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://hlj.wiki");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}
