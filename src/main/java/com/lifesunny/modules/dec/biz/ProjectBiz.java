package com.lifesunny.modules.dec.biz;

import com.alibaba.fastjson.JSONObject;
import com.lifesunny.common.utils.DateUtils;
import com.lifesunny.modules.dec.entity.ProjectEntity;
import com.lifesunny.modules.dec.param.project.ProjectOperateParam;
import com.lifesunny.modules.dec.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/12/4 17:46
 */
@Component
public class ProjectBiz {

    @Autowired
    private ProjectService projectService;
    /**
     * 保存项目
     *
     * @param param
     */
    public void save(ProjectOperateParam param) {
        ProjectEntity entity = new ProjectEntity();
        BeanUtils.copyProperties(param, entity);
        entity.setDesignerId(Long.parseLong(param.getDesigner().split(":")[0]));
        entity.setDesignerName(param.getDesigner().split(":")[1]);
        entity.setManagerId(Long.parseLong(param.getManager().split(":")[0]));
        entity.setManagerName(param.getManager().split(":")[1]);
        entity.setMaterialMess(JSONObject.toJSONString(param.getMaterials()));
        projectService.insert(entity);
    }
}