package com.lifesunny.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lifesunny.modules.sys.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
