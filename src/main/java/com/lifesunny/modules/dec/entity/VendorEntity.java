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
 * @date 2018-12-02 16:23:10
 */
@TableName("dec_vendor")
public class VendorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 供商名称（合作商家）
	 */
	private String companyName;
	/**
	 * 联系人
	 */
	private String contactName;
	/**
	 * l联系电话
	 */
	private String contactTel;
	/**
	 * 联系地址
	 */
	private String contactAdd;
	/**
	 * 经营的材料列表
	 */
	private String materialIds;
	/**
	 * 业务状态:1有效 0：无效
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
	 * 设置：供商名称（合作商家）
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：供商名称（合作商家）
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：l联系电话
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	/**
	 * 获取：l联系电话
	 */
	public String getContactTel() {
		return contactTel;
	}
	/**
	 * 设置：联系地址
	 */
	public void setContactAdd(String contactAdd) {
		this.contactAdd = contactAdd;
	}
	/**
	 * 获取：联系地址
	 */
	public String getContactAdd() {
		return contactAdd;
	}
	/**
	 * 设置：经营的材料列表
	 */
	public void setMaterialIds(String materialIds) {
		this.materialIds = materialIds;
	}
	/**
	 * 获取：经营的材料列表
	 */
	public String getMaterialIds() {
		return materialIds;
	}
	/**
	 * 设置：业务状态:1有效 0：无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：业务状态:1有效 0：无效
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
