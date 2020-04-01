package com.hlx.nutritionist.service.impl;

import com.hlx.nutritionist.dao.TbUserDao;
import com.hlx.nutritionist.entity.TbUserEntity;
import com.hlx.nutritionist.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/4/1 10:22
 * @Version 1.0
 */
@Service
public class MembersServiceImpl implements MembersService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUserEntity> getMembers() {
        return tbUserDao.findAll();
    }

    @Override
    public TbUserEntity getMember(Long id) {
        return tbUserDao.findById(id);
    }

    @Override
    public String deleteMember(Long id) {

        int rs = tbUserDao.deleteById(id);

        if(rs>0){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @Override
    public String editMember(Long id, String username, String password, String mobile, String displayName) {

        int rs = tbUserDao.updateMembers(id,username,password,mobile,displayName);

        if(rs>0){
            return "修改成功";
        }else{
            return "修改失败";
        }

    }
}
