package express.yb.upc.edu.cn.model;

import javax.persistence.*;

/**
 * Created by wh980 on 2016/5/30.
 */
@Table (name="Order")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int statusid;
    private String number;
    private String company;
    private String details;
    private String mobilenumber;
    private String username;



}
