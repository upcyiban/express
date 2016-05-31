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
}
