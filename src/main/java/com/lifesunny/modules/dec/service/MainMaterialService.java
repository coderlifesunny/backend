package com.lifesunny.modules.dec.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.entity.MainMaterialEntity;

import java.util.Map;

/**
 * 主要材料表，有多种类型，硬材，软材，辅材，其他
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 15:46:28
 */
public interface MainMaterialService extends IService<MainMaterialEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

