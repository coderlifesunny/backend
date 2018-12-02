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

import com.lifesunny.modules.dec.entity.VendorEntity;
import com.lifesunny.modules.dec.service.VendorService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.entity.HttpResult;


/**
 * 
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 16:23:10
 */
@RestController
@RequestMapping("dec/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dec:vendor:list")
    public HttpResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = vendorService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dec:vendor:info")
    public HttpResult info(@PathVariable("id") Integer id) {
            VendorEntity vendor = vendorService.selectById(id);

        return HttpResult.ok().put("vendor", vendor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dec:vendor:save")
    public HttpResult save(@RequestBody VendorEntity vendor) {
            vendorService.insert(vendor);

        return HttpResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dec:vendor:update")
    public HttpResult update(@RequestBody VendorEntity vendor) {
            vendorService.updateById(vendor);

        return HttpResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dec:vendor:delete")
    public HttpResult delete(@RequestBody Integer[]ids) {
            vendorService.deleteBatchIds(Arrays.asList(ids));

        return HttpResult.ok();
    }

}
