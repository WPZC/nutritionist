package com.hlx.nutritionist.dao;

import com.hlx.nutritionist.entity.TbProductPicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/3/31 15:30
 * @Version 1.0
 */
public interface TbProductPicDao extends JpaRepository<TbProductPicEntity,Integer> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "delete from tb_product_pic where p_id = ?1")
    int deleteByPId(Long id);

    @Query(nativeQuery = true,value = "select * from tb_product_pic where p_id = ?1")
    List<TbProductPicEntity> findByPId(Long id);

    @Query(nativeQuery = true,value = "select * from tb_product_pic where p_id = ?1 limit 0,1")
    TbProductPicEntity findByPIdLimit1(Long id);
}
