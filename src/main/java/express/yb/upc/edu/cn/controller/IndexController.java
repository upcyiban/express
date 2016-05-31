package express.yb.upc.edu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2016/5/31.
 */
@Controller
public class IndexController {

@RequestMapping("/")
    public String ShowIndex(){
    return "";
}
}
