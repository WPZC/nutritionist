package com.hlx.nutritionist.service;

import com.hlx.nutritionist.entity.TbUserEntity;

/**
 * @Author WQY
 * @Date 2020/3/30 15:39
 * @Version 1.0
 */
public interface LoginService {

    TbUserEntity findByUsernameAndPassword(String username,String password);

}
