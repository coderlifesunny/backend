package com.lifesunny.modules.dec.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifesunny.modules.dec.entity.StandardEntity;
import com.lifesunny.modules.dec.service.StandardService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.entity.HttpResult;


/**
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 10:42:34
 */
@RestController
@RequestMapping("dec/standard")
public class StandardController {
    @Autowired
    private StandardService standardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dec:standard:list")
    public HttpResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = standardService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dec:standard:info")
    public HttpResult info(@PathVariable("id") Long id) {
        StandardEntity standard = standardService.selectById(id);

        return HttpResult.ok().put("standard", standard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dec:standard:save")
    public HttpResult save(@RequestBody StandardEntity standard) {
        standardService.insert(standard);

        return HttpResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dec:standard:update")
    public HttpResult update(@RequestBody StandardEntity standard) {
        standardService.updateById(standard);

        return HttpResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dec:standard:delete")
    public HttpResult delete(@RequestBody Long[] ids) {
        standardService.deleteBatchIds(Arrays.asList(ids));

        return HttpResult.ok();
    }

}
