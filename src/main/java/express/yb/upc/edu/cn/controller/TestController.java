package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.service.GetPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 陈子枫 on 2016/6/20.
 */
@RestController
public class TestController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    GetPay getPay;

    @RequestMapping("/test")
    String acc(){
        return httpSession.getAttribute("access_token").toString();
    }

    @RequestMapping("/pay")
    public String pay(){
        try {
            getPay.getMessage((String)httpSession.getAttribute("access_token"),"1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";

    }


}
