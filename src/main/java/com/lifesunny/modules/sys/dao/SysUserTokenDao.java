package com.lifesunny.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lifesunny.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
	
}
