package com.lifesunny.modules.dec.biz;

import com.alibaba.fastjson.JSONObject;
import com.lifesunny.modules.dec.entity.ProjectEntity;
import com.lifesunny.modules.dec.param.project.ModifyParam;
import com.lifesunny.modules.dec.param.project.ProjectOperateParam;
import com.lifesunny.modules.dec.service.ProjectService;
import com.lifesunny.modules.dec.vo.DashboardVO;
import com.lifesunny.modules.dec.vo.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        projectService.insert(convertEntity(param));
    }

    /**
     * 修改项目
     *
     * @param param
     */
    public void modify(ModifyParam param) {
        projectService.updateById(convertEntity(param));
    }

    /**
     * 修改标的状态
     *
     * @param id
     * @param status
     */
    public void modifyStatus(Integer id, Integer status) {
        ProjectEntity entity = new ProjectEntity();
        entity.setId(id);
        entity.setStatus(status);
        projectService.updateById(entity);
    }

    /**
     * 查询项目信息
     *
     * @param id
     * @param type
     * @return
     */
    public ProjectVO info(Integer id, Integer type) {
        ProjectEntity project = projectService.selectById(id);
        return new ProjectVO().build(project, type);
    }

    private ProjectEntity convertEntity(ProjectOperateParam param) {
        ProjectEntity entity = new ProjectEntity();
        BeanUtils.copyProperties(param, entity);
        entity.setDesignerId(Long.parseLong(param.getDesigner().split(":")[0]));
        entity.setDesignerName(param.getDesigner().split(":")[1]);
        entity.setManagerId(Long.parseLong(param.getManager().split(":")[0]));
        entity.setManagerName(param.getManager().split(":")[1]);
        entity.setMaterialMess(JSONObject.toJSONString(param.getMaterials()));
        entity.setCreateTime(new Date());
        return entity;
    }

    /**
     * 查询仪表盘上的统计信息
     * @return
     */
    private DashboardVO dashboard(){
        return new DashboardVO();
    }

}