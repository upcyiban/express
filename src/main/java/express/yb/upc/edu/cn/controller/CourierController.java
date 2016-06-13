package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.confing.DevConfig;
import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by wanghaojun on 2016/6/4.
 */
@Controller
public class CourierController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private HttpSession session;


    /**
     * 管理员登录界面
     *
     * @return
     */
    @RequestMapping("/courierlogin")
    public String loginAdmin() {
        if (session.getAttribute("user") == null) {
            return "courierlogin";
        } else {
            return "redirect:officialadmin";
        }
    }

    /**
     * 验证管理员密码错误自动返回登陆界面，密码正确返回管理员界面
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/courierlogin", method = RequestMethod.POST)
    public String loginResult(String username, String password) {
        if ((Objects.equals(username, DevConfig.adminUsername)) && (Objects.equals(password, DevConfig.adminPassword))) {
            session.setAttribute("user", "admin");
            return "redirect:officialadmin";
        } else {
            return "login";//web
        }
    }

    //快递员显示页面
    @RequestMapping("/courierlist")
    public String courierList(Model model) {
        if (session.getAttribute("user") == null) {
            return "courierlogin";//web
        } else {
            Iterable<Order> orders = orderDao.findAll();

            model.addAttribute("orders", orders);
            return "courierlist";
        }
    }

    //快递员确认订单
    @RequestMapping("/changecouriervalue")
    public String changeCourierValue(int id) {
        Order order = orderDao.findOne(id);
        if (Objects.equals(order.getCouriervalue(), "未确认")) {
            order.setCouriervalue("已确认");
        } else {
            order.setCouriervalue("未确认");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }


    //快递员确认订单完成
    @RequestMapping("/changeordervalue")
    public String changeorderValue(int id) {
        Order order = orderDao.findOne(id);
        if (Objects.equals(order.getOrdervalue(), "未确认") && Objects.equals(order.getUservalue(), "已确认") && Objects.equals(order.getCouriervalue(), "已确认")) {
            order.setOrdervalue("已确认");
        } else {
            order.setOrdervalue("未确认");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }

}
