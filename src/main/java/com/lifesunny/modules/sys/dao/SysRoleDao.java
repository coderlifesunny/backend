package com.lifesunny.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lifesunny.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
