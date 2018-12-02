package com.lifesunny.modules.dec.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.utils.Query;

import com.lifesunny.modules.dec.dao.VendorDao;
import com.lifesunny.modules.dec.entity.VendorEntity;
import com.lifesunny.modules.dec.service.VendorService;


@Service("vendorService")
public class VendorServiceImpl extends ServiceImpl<VendorDao, VendorEntity> implements VendorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VendorEntity> page = this.selectPage(
                new Query<VendorEntity>(params).getPage(),
                new EntityWrapper<VendorEntity>().like("company_name", (String) params.get("name")).eq("status", params.get("status"))
        );

        return new PageUtils(page);
    }

}
