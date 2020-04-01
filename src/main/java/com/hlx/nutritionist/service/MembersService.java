package com.hlx.nutritionist.service;

import com.hlx.nutritionist.entity.TbUserEntity;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/4/1 10:22
 * @Version 1.0
 */
public interface MembersService {

    /**
     * 获取所有用户
     * @return
     */
    List<TbUserEntity> getMembers();

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    TbUserEntity getMember(Long id);

    /**
     *删除会员
     * @param id
     * @return
     */
    String deleteMember(Long id);

    /**
     * 编辑用户
     * @param id
     * @param username
     * @param password
     * @param mobile
     * @param displayName
     * @return
     */
    String editMember(Long id,String username,String password,String mobile,String displayName);
}
