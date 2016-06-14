package express.yb.upc.edu.cn.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by 陈子枫 on 2016/6/14.
 */
@Service
public class GetRealMessage {
    @Autowired
    private HttpSession httpSession;

    public String getMessage(String access_token, String pay) throws IOException {
        String url = "https://openapi.yiban.cn/pay/yb_wx" + pay;
        String charset = "UTF-8";

        String query = String.format("access_token=%s",
                URLEncoder.encode(access_token, charset));
        String query1 = String.format("pay=%s",
                URLEncoder.encode(pay, charset));
        URLConnection connection = new URL(url + "?" + query + '&' + query1).openConnection();
        InputStream response = connection.getInputStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;
        while ((read = br.readLine()) != null) {
            sb.append(read);
        }

        br.close();

        return sb.toString();


    }
}
