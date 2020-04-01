package com.hlx.nutritionist.dao;

import com.hlx.nutritionist.entity.TbUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author WQY
 * @Date 2020/3/30 15:42
 * @Version 1.0
 */
public interface TbUserDao extends JpaRepository<TbUserEntity,Integer> {

    /**
     * 根据用户名密码进行查询
     * @param username
     * @param password
     * @return
     */
    TbUserEntity findByUsernameAndPassword(String username,String password);

    @Query(nativeQuery = true,value = "select * from tb_user where id = ?1")
    TbUserEntity findById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "delete from tb_user where id = ?1")
    int deleteById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "update tb_user set username = ?2,password = ?3,mobile = ?4,display_name = ?5 where id = ?1")
    int updateMembers(Long id, String username, String password, String mobile, String displayName);

}
