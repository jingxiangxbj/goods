package com.jingxiang.goods.controller;

import com.jingxiang.goods.entity.Result;
import com.jingxiang.goods.entity.User;
import com.jingxiang.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(@RequestParam("username")String username,@RequestParam("password")String password){
        User user = userService.findByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                // 将登陆用户信息存入到session域对象中
                attributes.getRequest().getSession().setAttribute("user", user.getUsername());
            }
            return new Result(true,username);
        }
        return new Result(false,"登录失败！");
    }
    @RequestMapping("/register")
    public Result register(@RequestParam("username")String username,@RequestParam("password")String password){
        if (userService.findByName(username)!=null){
            return new Result(false,"用户已存在！");
        }
        try {
            userService.create(new User(username, password));
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            attributes.getRequest().getSession().setAttribute("user", new User(username, password));
            return new Result(true,"注册成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"注册失败！");
        }

    }
    @RequestMapping("/logout")
    public String logout(){
      ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      attributes.getRequest().getSession().removeAttribute("user");
      return "home/login";
    }
    @GetMapping("/login")
    public String login(){
        return "home/login";
    }
    @GetMapping("/register")
        public String register(){
            return "home/register";
        }

}
