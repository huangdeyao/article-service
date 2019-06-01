package com.dy.oauth2service.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


/**
 * @author root
 */
@Configuration
public class Oauth2ServerConfig {

    private static final String DEMO_RESOURCE_ID = "article";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.exceptionHandling()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/get/**").permitAll()
                    .antMatchers("/api/add/**", "/api/update/**", "/api/delete/**").authenticated();
        }

    }

}
