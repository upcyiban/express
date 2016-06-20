package express.yb.upc.edu.cn.GsonTemplate;

/**
 * Created by 陈子枫 on 2016/6/20.
 */
public class RealUserInfo {
    public String status;
    public RealInfo info;

    public class RealInfo {
        public int yb_userid;
        public String yb_username;
        public String yb_usernick;
        public char yb_sex;
        public int yb_money;
        public int yb_exp;
        public String yb_userhead;
        public int yb_schoolid;
        public String yb_schoolname;
        public String yb_regtime;
        public String yb_realname;
        public String yb_studentid;
        public String yb_identity;
    }

}
