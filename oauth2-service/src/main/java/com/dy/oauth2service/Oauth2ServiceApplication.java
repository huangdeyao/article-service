package com.dy.oauth2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author huangdeyao
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
@EnableResourceServer
public class Oauth2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServiceApplication.class, args);
    }
}
