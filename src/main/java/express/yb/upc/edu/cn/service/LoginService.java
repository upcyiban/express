package express.yb.upc.edu.cn.service;

import com.google.gson.Gson;
import express.yb.upc.edu.cn.GsonTemplate.VeriyPayInfo;
import express.yb.upc.edu.cn.confing.DevConfig;
import express.yb.upc.edu.cn.util.MCrypt;
import express.yb.upc.edu.cn.util.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2016/6/5.
 */
@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private GetPay getPay;

    public boolean procssAuthReal() throws IOException{
        String access_token = (String) httpSession.getAttribute("access_token");
        String message = getPay.getMessage(access_token,"yb_wx");
        return  saveRealSession(message);
    }


    /**
     * 保存学校验证信息的session
     * @param message
     * @return
     */
    public boolean saveRealSession(String message){
        Gson gson = new Gson();
        try {
            VeriyPayInfo veriyPayInfo = gson.fromJson(message,VeriyPayInfo.class);
            if(veriyPayInfo.payinfo){
                return true;
            }else {
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return  false;
        }
    }

    /**
     * 判断用户是否携带真实信息(学号)
     * @return
     */
    public boolean isAuthReal(){ return httpSession.getAttribute("yb_studentid")!=null;}


    public String toYibanAuth() {
        String auth = "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + DevConfig.client_id + "&redirect_uri=" + DevConfig.redirect_uri;
        return auth;
    }

    public boolean isLogin() {
        return httpSession.getAttribute("userid") != null;
    }

    /**
     * 处理授权.成功则跳转至/,失败则重新引导用户至易班授权模块
     * @param verify_request 易班服务器提供的信息,加密的.
     * @return
     * @throws Exception
     */
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
