package com.lifesunny.modules.dec.param.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lifesunny.modules.dec.param.project.materials.MaterialParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description: 项目操作参数
 *
 * @Author Guangcai.xu
 * @Date 2018/12/4 17:33
 */
@Data
@NoArgsConstructor
public class ProjectOperateParam {

    private String name;

    private String ownerName;

    private String ownerTel;

    private String designer;

    private String manager;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startContractTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endContractTime;

    private String remark;

    private MaterialParam materials;

    private Long createUserId;
}