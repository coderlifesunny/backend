package com.lifesunny.modules.sys.controller;


import com.lifesunny.common.annotation.SysLog;
import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.validator.ValidatorUtils;
import com.lifesunny.modules.sys.entity.SysConfigEntity;
import com.lifesunny.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 系统配置信息
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 所有配置列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:config:list")
	public HttpResult list(@RequestParam Map<String, Object> params){
		PageUtils page = sysConfigService.queryPage(params);

		return HttpResult.ok().put("page", page);
	}
	
	
	/**
	 * 配置信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	public HttpResult info(@PathVariable("id") Long id){
		SysConfigEntity config = sysConfigService.selectById(id);
		
		return HttpResult.ok().put("config", config);
	}
	
	/**
	 * 保存配置
	 */
	@SysLog("保存配置")
	@PostMapping("/save")
	@RequiresPermissions("sys:config:save")
	public HttpResult save(@RequestBody SysConfigEntity config){
		ValidatorUtils.validateEntity(config);

		sysConfigService.save(config);
		
		return HttpResult.ok();
	}
	
	/**
	 * 修改配置
	 */
	@SysLog("修改配置")
	@PostMapping("/update")
	@RequiresPermissions("sys:config:update")
	public HttpResult update(@RequestBody SysConfigEntity config){
		ValidatorUtils.validateEntity(config);
		
		sysConfigService.update(config);
		
		return HttpResult.ok();
	}
	
	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@PostMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public HttpResult delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);
		
		return HttpResult.ok();
	}

}
