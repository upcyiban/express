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
    private String address;
    private String number;
    private String expressaddress;
    private String details;
    private String phonenumber;
    private String username;

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getExpressaddress() {
        return expressaddress;
    }

    public String getDetails() {
        return details;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpressaddress(String expressaddress) {
        this.expressaddress = expressaddress;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {

        return username;
    }
}
