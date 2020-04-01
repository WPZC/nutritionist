package com.hlx.nutritionist.entity.view;

import com.hlx.nutritionist.entity.TbProductEntity;
import com.hlx.nutritionist.entity.TbProductPicEntity;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/3/31 17:07
 * @Version 1.0
 */
public class ProductView {

    private TbProductEntity tbProductEntity;

    private List<TbProductPicEntity> tbProductPicEntities;

    public TbProductEntity getTbProductEntity() {
        return tbProductEntity;
    }

    public void setTbProductEntity(TbProductEntity tbProductEntity) {
        this.tbProductEntity = tbProductEntity;
    }

    public List<TbProductPicEntity> getTbProductPicEntities() {
        return tbProductPicEntities;
    }

    public void setTbProductPicEntities(List<TbProductPicEntity> tbProductPicEntities) {
        this.tbProductPicEntities = tbProductPicEntities;
    }
}
