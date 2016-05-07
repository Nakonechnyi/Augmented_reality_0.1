package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @autor A_Nakonechnyi
 * @date 07.05.2016.
 */

@Controller
public class PageController {

    @Value("${application.message}")
    private String appVar;

    @RequestMapping("/jsp")
    public String getPage(Map<String, Object> model){
        System.out.println("PageController. ");
        System.out.println("AppVar = " + appVar);
        model.put("time", new Date());
        model.put("message", "JSP Hello!");
        return "welcome";
    }
}
