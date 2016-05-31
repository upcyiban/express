package express.yb.upc.edu.cn.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2016/5/31.
 */
@Table(name = "OrderStatus")
@Entity
public class OrderStatus {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private  int id;
    private String uservalue;
    private String couriervalue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUservalue() {
        return uservalue;
    }

    public void setUservalue(String uservalue) {
        this.uservalue = uservalue;
    }

    public String getCouriervalue() {
        return couriervalue;
    }

    public void setCouriervalue(String couriervalue) {
        this.couriervalue = couriervalue;
    }
}
