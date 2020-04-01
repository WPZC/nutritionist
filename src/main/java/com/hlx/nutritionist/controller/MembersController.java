package com.hlx.nutritionist.controller;

import com.hlx.nutritionist.entity.TbUserEntity;
import com.hlx.nutritionist.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/4/1 10:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/mc")
public class MembersController {

    @Autowired
    private MembersService membersService;

    /**
     * 跳转至会员页
     * @return
     */
    @RequestMapping("/tomembers")
    @ResponseBody
    public ModelAndView toMembers(){

        ModelAndView view = new ModelAndView("/html/members");

        return view;
    }

    /**
     * 获取所有会员
     * @return
     */
    @RequestMapping("/getmembers")
    @ResponseBody
    public List<TbUserEntity> getMembers(){

        return membersService.getMembers();

    }

    /**
     * 获取所有会员
     * @return
     */
    @RequestMapping("/getmember")
    @ResponseBody
    public TbUserEntity getMember(Long id){

        return membersService.getMember(id);

    }

    /**
     * 删除会员
     * @return
     */
    @RequestMapping("/deletemember")
    @ResponseBody
    public String deleteMember(Long id){

        return membersService.deleteMember(id);

    }

    /**
     * 删除会员
     * @return
     */
    @RequestMapping("/editmember")
    @ResponseBody
    public String editMember(Long id,String username,String password,String mobile,String displayName){

        return membersService.editMember(id,username,password,mobile,displayName);

    }



}
