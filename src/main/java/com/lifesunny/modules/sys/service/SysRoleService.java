package com.lifesunny.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void save(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
