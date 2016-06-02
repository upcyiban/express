package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;
import express.yb.upc.edu.cn.model.OrderStatus;
import express.yb.upc.edu.cn.model.OrderStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


/**
 * Created by lenovo on 2016/5/31.
 */
@Controller
public class IndexController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderStatusDao orderStatusDao;

    @RequestMapping("/")
    public String ShowIndex(int userid,int orderid,Model model) {

        Iterable<Order> lists = orderDao.findByUserid(userid);
        Iterable<OrderStatus> orderlist = orderStatusDao.findByOrderid(orderid);

        model.addAttribute("lists",lists);
        model.addAttribute("orderlist",orderlist);
        return "index";
    }

    public String TestId(int userid, Model model) {

        Collection<Order> orders = (Collection<Order>) orderDao.findByUserid(userid);
        if (orders.isEmpty()) {
            model.addAttribute("result", "请先登录");
        } else {
            model.addAttribute("result", "登录成功");
        }
   return "index";
    }
}
