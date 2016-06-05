package express.yb.upc.edu.cn.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2016/5/31.
 */

@Entity
@Table(name = "express_orderstatus")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String orderid;
    private boolean uesrvalue = false;//用户确认订单
    private boolean couriervalue = false;//接单员最终确认
    private  boolean ordervalue = false;//确认接单

    public OrderStatus(String orderid, boolean uesrvalue, boolean couriervalue, boolean ordervalue) {
        this.orderid = orderid;
        this.uesrvalue = uesrvalue;
        this.couriervalue = couriervalue;
        this.ordervalue = ordervalue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public boolean isUesrvalue() {
        return uesrvalue;
    }

    public void setUesrvalue(boolean uesrvalue) {
        this.uesrvalue = uesrvalue;
    }

    public boolean isCouriervalue() {
        return couriervalue;
    }

    public void setCouriervalue(boolean couriervalue) {
        this.couriervalue = couriervalue;
    }

    public boolean isOrdervalue() {
        return ordervalue;
    }

    public void setOrdervalue(boolean ordervalue) {
        this.ordervalue = ordervalue;
    }
}
