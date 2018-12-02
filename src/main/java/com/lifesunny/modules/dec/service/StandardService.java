package com.lifesunny.modules.dec.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.entity.StandardEntity;

import java.util.Map;

/**
 * 
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 10:42:34
 */
public interface StandardService extends IService<StandardEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

