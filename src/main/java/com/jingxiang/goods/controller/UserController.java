package com.jingxiang.goods.controller;

import com.jingxiang.goods.entity.User;
import com.jingxiang.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<User> findAll(){
      return userService.findAll();
    }
}
