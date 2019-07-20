package com.jingxiang.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "home/index";
    }
    @RequestMapping("/goods")
    public String user(){
        return "site/goods";
    }

}
