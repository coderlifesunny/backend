package com.lifesunny.modules.dec.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 主要材料表，有多种类型，硬材，软材，辅材，其他
 * 
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 15:46:28
 */
@TableName("dec_main_material")
public class MainMaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 主材名称
	 */
	private String name;
	/**
	 * 1硬材，1软材，3辅材，4其他
	 */
	private Integer type;
	/**
	 * 业务状态
	 */
	private Integer status;
	/**
	 * 主材图片写死的
	 */
	private String imgUrl;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：主材名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：主材名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：1硬材，1软材，3辅材，4其他
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1硬材，1软材，3辅材，4其他
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：业务状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：业务状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：主材图片写死的
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：主材图片写死的
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：创建者ID
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建者ID
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
