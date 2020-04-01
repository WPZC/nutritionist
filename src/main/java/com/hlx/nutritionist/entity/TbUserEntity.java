package com.hlx.nutritionist.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description  
 * @Author  WQY
 * @Date 2020-04-01 
 */

@Entity
@Table ( name ="tb_user" )
public class TbUserEntity  {


	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 用户名
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 密码
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * 昵称
	 */
   	@Column(name = "display_name" )
	private String displayName;

	/**
	 * 性别
	 */
   	@Column(name = "sex" )
	private Integer sex;

	/**
	 * 年龄
	 */
   	@Column(name = "age" )
	private Long age;

	/**
	 * 联系方式
	 */
   	@Column(name = "mobile" )
	private String mobile;

	/**
	 * 生日
	 */
   	@Column(name = "birthday" )
	private Date birthday;

	/**
	 * 地址
	 */
   	@Column(name = "address" )
	private String address;

	/**
	 * 是否会员
	 */
   	@Column(name = "is_vip" )
	private Integer isVip;

	/**
	 * 是否有效
	 */
   	@Column(name = "is_enable" )
	private Integer isEnable;

	/**
	 * 卡号
	 */
   	@Column(name = "card_no" )
	private String cardNo;

	/**
	 * 会员等级
	 */
   	@Column(name = "level" )
	private String level;

	/**
	 * 创建时间
	 */
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 修改时间
	 */
   	@Column(name = "update_time" )
	private Date updateTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsVip() {
		return this.isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	public Integer getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
