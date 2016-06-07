package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

/**
 * Created by wanghaojun on 2016/6/4.
 */
@Controller
public class CourierController {
    @Autowired
    private OrderDao orderDao;



    //快递员显示页面
    @RequestMapping("/courierlist")
    public String courierList (Model model)
    {
          Iterable<Order> orders=orderDao.findAll();

          model.addAttribute("orders",orders);
          return "courierlist";
    }

    //快递员确认订单
    @RequestMapping("/changecouriervalue")
    public String changeCourierValue(int id){
        Order order=orderDao.findOne(id);
        if (Objects.equals(order.getCouriervalue(), "未确认"))
        {
            order.setCouriervalue("已确认");
        }
        else{
            order.setCouriervalue("未确认");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }
    //用户确认收到
    @RequestMapping("/changeuservalue")
    public String changeUserValue(int id){
        Order order=orderDao.findOne(id);
        if (Objects.equals(order.getUesrvalue(), "未确认"))
        {
            order.setUesrvalue("已确认");
        }
        else{
            order.setUesrvalue("未确认");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }

    //快递员确认订单完成
    @RequestMapping("/changeordervalue")
    public String changeorderValue(int id){
        Order order=orderDao.findOne(id);
        if (Objects.equals(order.getOrdervalue(), "未确认") && Objects.equals(order.getUesrvalue(), "已确认") && Objects.equals(order.getCouriervalue(), "已确认"))
        {
            order.setOrdervalue("已确认");
        }
        else{
            order.setOrdervalue("未确认");
        }
        orderDao.save(order);
        return "redirect:courierlist";

    }

}
