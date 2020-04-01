package com.hlx.nutritionist.dao;

import com.hlx.nutritionist.entity.TbProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/3/30 16:24
 * @Version 1.0
 */
public interface TbProductDao extends JpaRepository<TbProductEntity,Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "delete from tb_product where id = ?1")
    int deleteById(Long id);

    @Query(nativeQuery = true,value = "select * from tb_product where id = ?1")
    TbProductEntity findById(Long id);

    @Query(nativeQuery = true,value = "select * from tb_product limit 0,3")
    List<TbProductEntity> findAllLimit3();

}
