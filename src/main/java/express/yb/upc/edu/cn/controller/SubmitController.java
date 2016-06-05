package express.yb.upc.edu.cn.controller;

import express.yb.upc.edu.cn.model.Order;
import express.yb.upc.edu.cn.model.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Created by wh980 on 2016/6/1.
 */
@Controller
public class SubmitController {
    @Autowired
    private OrderDao orderDao;


    @RequestMapping("/informationsubmit")
    public String showSubmit()
    {
        return "informationsubmit";
    }
     @RequestMapping (value = "/submit", method = RequestMethod.POST)
  public String submitDate(String username,String number,String company,String mobilenumber,String details){
        String creattime=new Date().toString();
         String yiban="0";
        Order order=new Order(yiban, number,company, details, mobilenumber, username, creattime);
        orderDao.save(order);
        return "submitsuccess";
    }





}