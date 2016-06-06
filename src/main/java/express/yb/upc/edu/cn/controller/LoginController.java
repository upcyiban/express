package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/**
 * Created by lenovo on 2016/6/5.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/yibanauth")
    public String auth() {
        return loginService.toYibanAuth();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "verify_request")
    public String processAuth(String verify_request) throws Exception {
        return loginService.processAuth(verify_request);
    }
}