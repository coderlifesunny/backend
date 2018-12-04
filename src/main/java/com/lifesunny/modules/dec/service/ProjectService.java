package com.lifesunny.modules.dec.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.entity.ProjectEntity;

import java.util.Map;

/**
 * 
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-03 13:51:09
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

