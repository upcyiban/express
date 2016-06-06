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

    public Order(String yibanid, String number, String company, String details, String mobilenumber, String username, String creattime) {
        this.yibanid = yibanid;
        this.number = number;
        this.company = company;
        this.details = details;
        this.mobilenumber = mobilenumber;
        this.username = username;
        this.creattime = creattime;
    }
    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYibanid() {
        return yibanid;
    }

    public void setYibanid(String yibanid) {
        this.yibanid = yibanid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }
}
