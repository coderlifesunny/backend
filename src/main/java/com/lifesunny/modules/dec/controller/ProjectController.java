package com.lifesunny.modules.dec.controller;

import com.lifesunny.common.constants.Constant;
import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.biz.ProjectBiz;
import com.lifesunny.modules.dec.param.project.ModifyParam;
import com.lifesunny.modules.dec.param.project.ProjectOperateParam;
import com.lifesunny.modules.dec.service.ProjectService;
import com.lifesunny.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.util.bcel.Const;
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
public class ProjectController extends AbstractController {

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
        if (null == params.get("status")) {
            params.put("status", Constant.N_999);
        }
        PageUtils page = projectService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dec:project:info")
    public HttpResult info(@PathVariable("id") Integer id, @RequestParam Integer type) {
        return HttpResult.ok().put("project", projectBiz.info(id, type));
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
    public HttpResult update(@RequestBody ModifyParam param) {
        projectBiz.modify(param);
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

    /**
     * 修改工地的状态
     *
     * @param id
     * @param status 将要修改成的状态值
     * @return
     */
    @RequestMapping("/modifyStatus/{id}")
    @RequiresPermissions("dec:project:modifyStatus")
    public HttpResult modifyStatus(@PathVariable Integer id, @RequestParam Integer status) {
        projectBiz.modifyStatus(id, status);
        return HttpResult.ok();
    }

    @RequestMapping("/dashboard")
    public HttpResult dashboard() {
        return HttpResult.ok();
    }

}
