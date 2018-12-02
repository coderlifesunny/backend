package com.lifesunny.modules.dec.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 10:42:34
 */
@TableName("dec_standard")
public class StandardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 主材名称
	 */
	private String name;
	/**
	 * 业务状态:0无效  1有效
	 */
	private Integer status;
	/**
	 * 备注信息
	 */
	private String remark;
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
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
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
	 * 设置：业务状态:0无效  1有效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：业务状态:0无效  1有效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemark() {
		return remark;
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
