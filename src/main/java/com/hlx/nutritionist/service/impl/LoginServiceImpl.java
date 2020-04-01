package com.hlx.nutritionist.service.impl;

import com.hlx.nutritionist.dao.TbUserDao;
import com.hlx.nutritionist.entity.TbUserEntity;
import com.hlx.nutritionist.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WQY
 * @Date 2020/3/30 15:44
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUserEntity findByUsernameAndPassword(String username, String password) {

        //根据用户名密码查询用户信息
        TbUserEntity tbUserEntity = tbUserDao.findByUsernameAndPassword(username,password);

        //用户信息不等于空则用户名密码正确
        if(tbUserEntity!=null){
            return tbUserEntity;
        }

        return null;
    }
}
