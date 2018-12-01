package com.lifesunny.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lifesunny.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
