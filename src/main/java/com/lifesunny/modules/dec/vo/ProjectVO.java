package com.lifesunny.modules.dec.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.lifesunny.common.enums.InfoTypeEnum;
import com.lifesunny.modules.dec.entity.ProjectEntity;
import com.lifesunny.modules.dec.param.project.materials.MaterialParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 返回前端的VO对象
 *
 * @Author Guangcai.xu
 * @Date 2018/12/6 9:45
 */
@Data
@NoArgsConstructor
public class ProjectVO {

    private Integer id;

    private String name;

    private Integer status = 0;

    private String ownerName;

    private String ownerTel;

    private String designer;

    private String manager;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startContractTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endContractTime;

    private String remark;

    private MaterialParam materials;

    public ProjectVO build(ProjectEntity entity, Integer type) {
        if (null == entity) {
            return this;
        }
        BeanUtils.copyProperties(entity, this);
        if (InfoTypeEnum.VIEW == InfoTypeEnum.byValue(type)) {
            this.setDesigner(entity.getDesignerName());
            this.setManager(entity.getManagerName());
        } else {
            this.setDesigner(entity.getDesignerId() + ":" + entity.getDesignerName());
            this.setManager(entity.getManagerId() + ":" + entity.getManagerName());
        }
        String materialMess = entity.getMaterialMess();
        Gson gson = new Gson();
        MaterialParam materialParam = gson.fromJson(materialMess, MaterialParam.class);
        this.setMaterials(materialParam);
        return this;
    }
}