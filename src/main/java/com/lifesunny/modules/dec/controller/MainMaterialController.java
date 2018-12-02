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

import com.lifesunny.modules.dec.entity.MainMaterialEntity;
import com.lifesunny.modules.dec.service.MainMaterialService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.entity.HttpResult;


/**
 * 主要材料表，有多种类型，硬材，软材，辅材，其他
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 15:46:28
 */
@RestController
@RequestMapping("dec/main_material")
public class MainMaterialController {
    @Autowired
    private MainMaterialService mainMaterialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dec:main_material:list")
    public HttpResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = mainMaterialService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dec:main_material:info")
    public HttpResult info(@PathVariable("id") Integer id) {
        MainMaterialEntity mainMaterial = mainMaterialService.selectById(id);

        return HttpResult.ok().put("mainMaterial", mainMaterial);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dec:main_material:save")
    public HttpResult save(@RequestBody MainMaterialEntity mainMaterial) {
        mainMaterialService.insert(mainMaterial);

        return HttpResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dec:main_material:update")
    public HttpResult update(@RequestBody MainMaterialEntity mainMaterial) {
        mainMaterialService.updateById(mainMaterial);
        return HttpResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dec:main_material:delete")
    public HttpResult delete(@RequestBody Integer[] ids) {
        mainMaterialService.deleteBatchIds(Arrays.asList(ids));

        return HttpResult.ok();
    }

}
