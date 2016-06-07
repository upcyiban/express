package express.yb.upc.edu.cn.model;

import javax.persistence.*;

/**
 * Created by lenovo on 2016/5/31.
 */
@Entity
@Table(name = "express_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private int yibanid;
    private String name;
    private String address;


    public User(String name, String telephone, String address) {
        this.name = name;
        this.address = address;
    }

    public User() {
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}
