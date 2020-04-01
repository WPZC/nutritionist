package com.hlx.nutritionist.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description  
 * @Author  WQY
 * @Date 2020-03-30 
 */

@Entity
@Table ( name ="tb_product" )
public class TbProductEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 与厂家提供的商品名一致
	 */
   	@Column(name = "sproduct" )
	private String sproduct;

	/**
	 * 与厂家提供的商品数量一致
	 */
   	@Column(name = "snumber" )
	private Long snumber;

	/**
	 * 商品售卖价格
	 */
   	@Column(name = "pprice" )
	private Double pprice;

	/**
	 * 是否临期
	 */
   	@Column(name = "is_mature" )
	private Integer isMature;

	/**
	 * 折扣
	 */
   	@Column(name = "discount" )
	private Long discount;

	/**
	 * 积分
	 */
   	@Column(name = "integral" )
	private Long integral;

	/**
	 * 是否上架
	 */
   	@Column(name = "is_grounding" )
	private Integer isGrounding;

	/**
	 * 上架时间
	 */
   	@Column(name = "ontheshelf_time" )
	private Date ontheshelfTime;

	/**
	 * 商品描述
	 */
	@Column(name = "description" )
	private String description;


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
