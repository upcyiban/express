package express.yb.upc.edu.cn.service;

import com.google.gson.Gson;
import express.yb.upc.edu.cn.confing.DevConfig;
import express.yb.upc.edu.cn.util.MCrypt;
import express.yb.upc.edu.cn.util.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2016/6/5.
 */
@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;

    public boolean isLogin() {
        return httpSession.getAttribute("userid") != null;
    }

    public String toYibanAuth() {
        String auth = "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + DevConfig.client_id + "&redirect_uri=" + DevConfig.redirect_uri;
        return auth;
    }

    public String processAuth(String verify_request) throws Exception {
        MCrypt mCrypt = new MCrypt();
        String res = new String(mCrypt.decrypt(verify_request));
        if (saveSession(res)) {
            return "redirect:/";
        } else {
            return "redirect:/yibanauth";
        }
    }

    private boolean saveSession(String str) {
        Gson gson = new Gson();
        try {
            SessionUser sessionUser = gson.fromJson(str, SessionUser.class);
            httpSession.setAttribute("visit_time", sessionUser.visit_time);
            httpSession.setAttribute("userid", sessionUser.visit_user.userid);
            httpSession.setAttribute("username", sessionUser.visit_user.username);
            httpSession.setAttribute("usernick", sessionUser.visit_user.usernick);
            httpSession.setAttribute("usersex", sessionUser.visit_user.usersex);
            httpSession.setAttribute("access_token", sessionUser.visit_oauth.access_token);
            httpSession.setAttribute("token_expires", sessionUser.visit_oauth.token_expires);
            return true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
        }
    }

}
