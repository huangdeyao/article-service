package com.dy.oauth2service.social.weixin.api.impl;

import com.dy.oauth2service.social.weixin.api.Weixin;
import com.dy.oauth2service.social.weixin.api.WeixinUserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

/**
 *
 */
public class WeiXinImpl extends AbstractOAuth2ApiBinding implements Weixin {

    /**
     * 获取用户信息的url
     */
    private static final String WEIXIN_URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    private ObjectMapper objectMapper = new ObjectMapper();

    Logger logger = LoggerFactory.getLogger(getClass());

    public WeiXinImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    @Override
    public WeixinUserInfo getUserInfo(String openId) {
        String url = WEIXIN_URL_GET_USER_INFO + openId;

        String result = getRestTemplate().getForObject(url, String.class);
        if (StringUtils.contains(result, "errcode")) {
            return null;
        }

        WeixinUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(result, WeixinUserInfo.class);
            logger.info("userInfo==>" + userInfo.getNickname());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    /**
     * 使用utf-8 替换默认的ISO-8859-1编码
     *
     * @return
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }
}
