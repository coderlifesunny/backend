package com.lifesunny.modules.dec.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.utils.Query;

import com.lifesunny.modules.dec.dao.StandardDao;
import com.lifesunny.modules.dec.entity.StandardEntity;
import com.lifesunny.modules.dec.service.StandardService;


@Service("standardService")
public class StandardServiceImpl extends ServiceImpl<StandardDao, StandardEntity> implements StandardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StandardEntity> page = this.selectPage(
                new Query<StandardEntity>(params).getPage(),
                new EntityWrapper<StandardEntity>().like("name", (String) params.get("name")).eq("status", params.get("status"))
        );

        return new PageUtils(page);
    }

}
