package com.lifesunny.modules.dec.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.modules.dec.entity.VendorEntity;

import java.util.Map;

/**
 * 
 *
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 16:23:10
 */
public interface VendorService extends IService<VendorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

