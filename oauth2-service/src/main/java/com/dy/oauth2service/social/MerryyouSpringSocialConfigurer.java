package com.dy.oauth2service.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 继承默认的社交登录配置，加入自定义的后处理逻辑
 * @author huangdeyao
 * @date 2018/12/18 16:46
 */
public class MerryyouSpringSocialConfigurer  extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public MerryyouSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        filter.setSignupUrl("/socialRegister");
        return (T) filter;
    }
}
