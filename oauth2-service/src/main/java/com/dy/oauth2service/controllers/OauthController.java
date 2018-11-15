package com.dy.oauth2service.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangdeyao
 * @create: 2018-11-15 17:51
 **/
@RestController
public class OauthController {

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
}
