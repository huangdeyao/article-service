package com.dy.oauth2service.social.weixin.connect;

import lombok.Data;
import org.springframework.social.oauth2.AccessGrant;

/**
 *
 * 微信的access_token信息。与标准OAuth2协议不同，微信在获取access_token时会同时返回openId,并没有单独的通过accessToke换取openId的服务
 *  *
 *  * 所以在这里继承了标准AccessGrant，添加了openId字段，作为对微信access_token信息的封装。
 *  * Created on 2018/1/11.
 * 处理微信返回的access_token类(添加openid)
 * @author huangdeyao
 * @date 2018/12/18 13:41
 */
@Data
public class WeixinAccessGrant extends AccessGrant {

    private String openId;

    public WeixinAccessGrant(String accessToken) {
        super(accessToken);
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
