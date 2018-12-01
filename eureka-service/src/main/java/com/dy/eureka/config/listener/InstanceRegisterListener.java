package com.dy.eureka.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;


/**
 * @author hdy
 */
@Configuration
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceRegisterListener.class);
    @Override
    public void onApplicationEvent(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
        LOGGER.info("服务：{}，注册成功了",eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName());
    }
}
