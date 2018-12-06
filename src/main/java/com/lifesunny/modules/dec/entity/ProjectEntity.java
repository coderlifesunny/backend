package com.lifesunny.modules.dec.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-03 13:51:09
 */
@TableName("dec_project")
public class ProjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     * 工地名称
     */
    private String name;

    /**
     * 业务状态:0未开工 1施工中 2已完工
     */
    private Integer status = 0;

    /**
     * 业主姓名
     */
    private String ownerName;
    /**
     * 业主电话
     */
    private String ownerTel;
    /**
     * 设计师ID
     */
    private Long designerId;
    /**
     * 设计师姓名
     */
    private String designerName;
    /**
     * 工长ID
     */
    private Long managerId;
    /**
     * 工长姓名
     */
    private String managerName;
    /**
     * 合同开始时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startContractTime;
    /**
     * 合同结束时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endContractTime;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 选材信息（JSON串）
     */
    @JsonIgnore
    private String materialMess;
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
     * 设置：工地名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：工地名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：业主姓名
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * 获取：业主姓名
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置：业主电话
     */
    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel;
    }

    /**
     * 获取：业主电话
     */
    public String getOwnerTel() {
        return ownerTel;
    }

    /**
     * 设置：设计师ID
     */
    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    /**
     * 获取：设计师ID
     */
    public Long getDesignerId() {
        return designerId;
    }

    /**
     * 设置：设计师姓名
     */
    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    /**
     * 获取：设计师姓名
     */
    public String getDesignerName() {
        return designerName;
    }

    /**
     * 设置：工长ID
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取：工长ID
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * 设置：工长姓名
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * 获取：工长姓名
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * 设置：合同开始时间
     */
    public void setStartContractTime(Date startContractTime) {
        this.startContractTime = startContractTime;
    }

    /**
     * 获取：合同开始时间
     */
    public Date getStartContractTime() {
        return startContractTime;
    }

    /**
     * 设置：合同结束时间
     */
    public void setEndContractTime(Date endContractTime) {
        this.endContractTime = endContractTime;
    }

    /**
     * 获取：合同结束时间
     */
    public Date getEndContractTime() {
        return endContractTime;
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
     * 设置：选材信息（JSON串）
     */
    public void setMaterialMess(String materialMess) {
        this.materialMess = materialMess;
    }

    /**
     * 获取：选材信息（JSON串）
     */
    public String getMaterialMess() {
        return materialMess;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
