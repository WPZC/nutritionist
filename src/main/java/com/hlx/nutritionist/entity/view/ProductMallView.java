package com.hlx.nutritionist.entity.view;

import com.hlx.nutritionist.entity.TbProductEntity;
import com.hlx.nutritionist.entity.TbProductPicEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @Author WQY
 * @Date 2020/3/31 17:07
 * @Version 1.0
 */
public class ProductMallView {


    private Long id;

    /**
     * 与厂家提供的商品名一致
     */
    private String sproduct;

    /**
     * 与厂家提供的商品数量一致
     */
    private Long snumber;

    /**
     * 商品售卖价格
     */
    private Double pprice;

    /**
     * 是否临期
     */
    private Integer isMature;

    /**
     * 折扣
     */
    private Long discount;

    /**
     * 积分
     */
    private Long integral;

    /**
     * 是否上架
     */
    private Integer isGrounding;

    /**
     * 上架时间
     */
    private Date ontheshelfTime;

    /**
     * 图片地址
     */
    private String picUrl;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSproduct() {
        return this.sproduct;
    }

    public void setSproduct(String sproduct) {
        this.sproduct = sproduct;
    }

    public Long getSnumber() {
        return this.snumber;
    }

    public void setSnumber(Long snumber) {
        this.snumber = snumber;
    }

    public Double getPprice() {
        return this.pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Integer getIsMature() {
        return this.isMature;
    }

    public void setIsMature(Integer isMature) {
        this.isMature = isMature;
    }

    public Long getDiscount() {
        return this.discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getIntegral() {
        return this.integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Integer getIsGrounding() {
        return this.isGrounding;
    }

    public void setIsGrounding(Integer isGrounding) {
        this.isGrounding = isGrounding;
    }

    public Date getOntheshelfTime() {
        return this.ontheshelfTime;
    }

    public void setOntheshelfTime(Date ontheshelfTime) {
        this.ontheshelfTime = ontheshelfTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
