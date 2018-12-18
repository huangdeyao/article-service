package com.dy.oauth2service.social.qq.config;

import com.dy.oauth2service.properties.SecurityConstants;
import com.dy.oauth2service.social.SocialConnectView;
import com.dy.oauth2service.social.qq.connect.QQConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * @author huangdeyao
 * @date 2018/12/18 16:31
 */
@Configuration
public class QQAuthConfig extends SocialAutoConfigurerAdapter {


    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(SecurityConstants.DEFAULT_SOCIAL_QQ_PROVIDER_ID, SecurityConstants.DEFAULT_SOCIAL_QQ_APP_ID, SecurityConstants.DEFAULT_SOCIAL_QQ_APP_SECRET);
    }

    /**
     * /connect/qq POST请求,绑定微信返回connect/weixinConnected视图
     * /connect/qq DELETE请求,解绑返回connect/weixinConnect视图
     * @return
     */
    @Bean({"connect/qqConnect", "connect/qqConnected"})
    @ConditionalOnMissingBean(name = "qqConnectedView")
    public View qqConnectedView() {
        return new SocialConnectView();
    }

}
