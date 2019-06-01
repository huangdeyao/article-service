package com.dy.oauth2service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: root
 * @create: 2018-11-15 17:51
 **/
@RestController
public class OauthController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/api/get/hello")
    public String getOauth() {
        return "get";
    }

    @RequestMapping(value = "/api/update/hello")
    public String updateOauth() {
        return "update";
    }


    @RequestMapping(value = "/api/add/hello")
    public String addOauth() {
        return "add";
    }

    @RequestMapping(value = "/api/delete/hello")
    public String deleteOauth() {
        return "delete";
    }

    /**
     * 做验证
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public Principal user(Principal user) {
        logger.info("++++++++++++++++++++++做验证++++++++++++++++++++++++++++++");
        return user;
    }
}
