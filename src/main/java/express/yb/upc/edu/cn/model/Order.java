package express.yb.upc.edu.cn.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Date;
import java.util.Calendar;
import java.util.Collection;
/**
 * Created by wh980 on 2016/5/30.
 */

@Entity
@Table (name = "express_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String yibanid;
    private String number;
    private String company;

    private String details;
    private String mobilenumber;
    private String username;

    private String creattime;
    private String uesrvalue = "未确认";//用户确认订单
    private String couriervalue ="未确认";//接单员最终确认
    private String ordervalue ="未确认";//确认接单

    public Order() {}
    public Order(String creattime, String username, String mobilenumber, String details, String company, String number, String yibanid) {
        this.creattime = creattime;
        this.username = username;
        this.mobilenumber = mobilenumber;
        this.details = details;
        this.company = company;
        this.number = number;
        this.yibanid = yibanid;
    }




    public int getId() {
        return id;
    }

    public String getYibanid() {
        return yibanid;
    }

    public String getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    public String getDetails() {
        return details;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getUsername() {
        return username;
    }

    public String getCreattime() {
        return creattime;
    }

    public String getUesrvalue() {
        return uesrvalue;
    }

    public String getCouriervalue() {
        return couriervalue;
    }

    public String getOrdervalue() {
        return ordervalue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYibanid(String yibanid) {
        this.yibanid = yibanid;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public void setUesrvalue(String uesrvalue) {
        this.uesrvalue = uesrvalue;
    }

    public void setCouriervalue(String couriervalue) {
        this.couriervalue = couriervalue;
    }

    public void setOrdervalue(String ordervalue) {
        this.ordervalue = ordervalue;
    }
}


