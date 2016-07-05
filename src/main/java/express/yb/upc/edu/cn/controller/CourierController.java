    package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.GsonTemplate.VeriyPayInfo;
import express.yb.upc.edu.cn.confing.DevConfig;
import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;

import express.yb.upc.edu.cn.service.GetPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by wanghaojun on 2016/6/4.
 */
@Controller
public class CourierController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private GetPay getPay;

    String access_token = null;
    String yb_wx ="2";


    /**
     * 管理员登录界面
     *
     * @return
     */
    @RequestMapping("/courierlogin")
    public String loginAdmin() {
        if (httpSession.getAttribute("user") == null) {
            System.out.println("1");
            return "courierlogin";
        } else {
            return "redirect:courierlist";
        }
    }

    @RequestMapping(value = "/courierlogin", method = RequestMethod.POST)
    public String loginResult(String username, String password) throws IOException {
        if ((Objects.equals(username, DevConfig.adminUsername)) && (Objects.equals(password, DevConfig.adminPassword))) {

            httpSession.setAttribute("user","admin");
           System.out.println((String)httpSession.getAttribute("user"));
//            System.out.println("access_token");

            return "redirect:courierlist";
        } else {
            return "redirect:courierlogin";//web
        }
    }

    //快递员显示页面
    @RequestMapping("/courierlist")
    public String courierList(Model model) {
        if (httpSession.getAttribute("user") == null) {
            System.out.println(12);
            return "redirect:courierlogin";//web
        } else {
            Iterable<Order> orders = orderDao.findByOrdervalue("未完成");
            model.addAttribute("orders", orders);
            return "courierlist";
        }
    }

    //快递员确认订单
    @RequestMapping("/changecouriervalue")
    public String changeCourierValue(int id) {
        Order order = orderDao.findOne(id);
        if (Objects.equals(order.getCouriervalue(), "未接单")) {
            order.setCouriervalue("已接单");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }


    //快递员确认订单完成
    @RequestMapping("/changeordervalue")
    public String changeorderValue(int id) throws IOException {
        Order order = orderDao.findOne(id);

        //GetPay realMessage = new GetPay();
        if (Objects.equals(order.getOrdervalue(), "未完成")  && Objects.equals(order.getCouriervalue(), "已接单")) {
            order.setOrdervalue("已完成");
            access_token = (String) httpSession.getAttribute("access_token");
            getPay.getMessage(access_token,DevConfig.yb_wx);
        }
        if (Objects.equals(order.getOrdervalue(), "已完成"))
        {
            ;
        }


       // String access_token = (String) httpSession.getAttribute("access_token");
//        if (Objects.equals(order.getOrdervalue(),"已完成")  && Objects.equals(order.getCouriervalue(),"已接单") && Objects.equals(order.getUservalue(),"0"))
//        {
//
//        }
        orderDao.save(order);

        return "redirect:/";

    }

}
