package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;
import express.yb.upc.edu.cn.model.OrderStatus;
import express.yb.upc.edu.cn.model.OrderStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanghaojun on 2016/6/4.
 */
@Controller
public class CourierController {
    @Autowired
    private OrderDao orderDao;
    private OrderStatusDao orderStatusDao;
    @RequestMapping("/courierlist")
    public String courierList (Model model1,Model model2)
    {
          Iterable<Order> orders=orderDao.findAll();
        Iterable<OrderStatus> orderStatuses=orderStatusDao.findAll();
        model1.addAttribute("oderstatuses",orderStatuses);
          model2.addAttribute("orders",orders);
          return "courierlist";
    }


}
