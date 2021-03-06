package com.lifesunny.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lifesunny.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);

	List<String> queryRolesByUserId(Long userId);

	/**
	 * 查询出所有的用户
	 * @return
	 */
	List<SysUserEntity> queryAllUsers4Dropdown(@Param("title") Integer title);

}
