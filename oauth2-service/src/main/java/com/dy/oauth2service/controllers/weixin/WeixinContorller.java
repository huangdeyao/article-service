package com.dy.oauth2service.controllers.weixin;


import com.dy.oauth2service.utils.weixin.mp.aes.AesException;
import com.dy.oauth2service.utils.weixin.mp.aes.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/weixin")
public class WeixinContorller {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 微信基本设置验证
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/token")
    public void weixinToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String token = "weixin";
        String sha1String = "";
        try {
            sha1String = SHA1.getSHA1(token, timestamp, nonce, "");
        } catch (AesException e) {
            e.printStackTrace();
        }
        logger.info("加密" + signature);
        logger.info("本身" + sha1String);
        PrintWriter out = response.getWriter();
        if (sha1String.equals(signature)) {
            out.print(echostr);
        }
    }
}
