package com.lifesunny.modules.dec.controller;

import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.biz.ProjectBiz;
import com.lifesunny.modules.dec.entity.ProjectEntity;
import com.lifesunny.modules.dec.param.project.ProjectOperateParam;
import com.lifesunny.modules.dec.service.ProjectService;
import com.lifesunny.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-03 13:51:09
 */
@RestController
@RequestMapping("dec/project")
public class ProjectController extends AbstractController{

    @Resource
    private ProjectBiz projectBiz;

    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dec:project:list")
    public HttpResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = projectService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dec:project:info")
    public HttpResult info(@PathVariable("id") Integer id) {
        ProjectEntity project = projectService.selectById(id);

        return HttpResult.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dec:project:save")
    public HttpResult save(@RequestBody ProjectOperateParam param) {
        param.setCreateUserId(getUserId());
        projectBiz.save(param);

        return HttpResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dec:project:update")
    public HttpResult update(@RequestBody ProjectEntity project) {
        projectService.updateById(project);

        return HttpResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dec:project:delete")
    public HttpResult delete(@RequestBody Integer[] ids) {
        projectService.deleteBatchIds(Arrays.asList(ids));

        return HttpResult.ok();
    }

}
