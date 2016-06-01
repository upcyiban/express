package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by lenovo on 2016/5/31.
 */
@Controller
public class IndexController {

    @Autowired
    private OrderDao orderDao;

    @RequestMapping("/")
    public String ShowIndex(int userid,Model model) {

        Iterable<Order> lists = orderDao.findByUserid(userid);
        model.addAttribute("lists",lists);
        return "index";
    }

}
