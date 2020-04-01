package com.hlx.nutritionist.entity;

import javax.persistence.*;

/**
 * @Description  
 * @Author  WQY
 * @Date 2020-03-31 
 */

@Entity
@Table ( name ="tb_product_pic" )
public class TbProductPicEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 商品id
	 */
   	@Column(name = "p_id" )
	private Long pId;

	/**
	 * 商品图片名称
	 */
   	@Column(name = "p_pic_name" )
	private String pPicName;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPId() {
		return this.pId;
	}

	public void setPId(Long pId) {
		this.pId = pId;
	}

	public String getPPicName() {
		return this.pPicName;
	}

	public void setPPicName(String pPicName) {
		this.pPicName = pPicName;
	}

}
