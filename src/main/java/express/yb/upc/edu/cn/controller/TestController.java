package express.yb.upc.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 陈子枫 on 2016/6/20.
 */
@RestController
public class TestController {

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/test")
    String acc(){
        return httpSession.getAttribute("access_token").toString();
    }
}
