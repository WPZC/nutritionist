package com.hlx.nutritionist.controller;

import com.hlx.nutritionist.entity.TbUserEntity;
import com.hlx.nutritionist.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录控制器
 * @Author WQY
 * @Date 2020/3/30 15:29
 * @Version 1.0
 */
@Controller
@RequestMapping("/lc")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView toLogin(){

        ModelAndView view = new ModelAndView("/login");

        view.addObject("failure","登录");
        return view;

    }

    @RequestMapping("/signin")
    @ResponseBody
    public ModelAndView signin(String username,String password){

        System.out.println(username+"---"+password);

        ModelAndView view = new ModelAndView();

        TbUserEntity rs = loginService.findByUsernameAndPassword(username,password);

        if (rs!=null){
            view.addObject("user",rs);
            view.setViewName("/index");
        }else{
            view.addObject("failure","用户名或密码错误");
            view.setViewName("/login");
        }

        return view;

    }

}
