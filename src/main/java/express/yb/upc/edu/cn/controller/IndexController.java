package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;

import express.yb.upc.edu.cn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Objects;


/**
 * Created by lenovo on 2016/5/31.
 */
@Controller
public class IndexController {

    @Autowired
    private OrderDao orderDao;


    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession httpSession;

    //@RequestMapping("/")
//    public String ShowIndex() {
//        System.out.println("1");
//
//        if (!loginService.isLogin()) {
//            return loginService.toYibanAuth();
//        }
//        System.out.println(2);
//        return "index";
//    }

    @RequestMapping("/")
    public String ShowIndex(Model model) {
        if (!loginService.isLogin()) {
            return loginService.toYibanAuth();
        }
        String userid = httpSession.getAttribute("userid").toString();
        String yibanid = userid;
        yibanid="1";


        Iterable<Order> lists = orderDao.findByYibanid(yibanid);


        model.addAttribute("lists", lists);

        return "index";
    }

    public String TestId(String yibanid, Model model) {

        Collection<Order> orders = (Collection<Order>) orderDao.findByYibanid(yibanid);
        if (orders.isEmpty()) {
            model.addAttribute("result", "请先登录");
        } else {
            model.addAttribute("result", "登录成功");
        }
        return "index";
    }

    //用户确认收到
    @RequestMapping("/changeuservalue")
    public String changeUserValue(int id) {
        Order order = orderDao.findOne(id);
        if (Objects.equals(order.getUservalue(), "未确认")) {
            order.setUservalue("已确认");
        } else {
            order.setUservalue("未确认");
        }
        orderDao.save(order);
        return "redirect:/";

    }
}
