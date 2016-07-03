package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by wh980 on 2016/6/1.
 */
@Controller
public class SubmitController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/informationsubmit")
    public String showSubmit() {
        return "informationsubmit";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitDate(String username, String number, String company, String mobilenumber, String details,String address1,String address0) {


        String yibanid = httpSession.getAttribute("userid").toString();

        String creattime = new Date().toString();

        String address =address0+address1;



        Order order = new Order(creattime, username, mobilenumber, details, company, number, yibanid,address);
        orderDao.save(order);
        return "success";
    }


}