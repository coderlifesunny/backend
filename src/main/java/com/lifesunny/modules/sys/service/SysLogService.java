package com.lifesunny.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
