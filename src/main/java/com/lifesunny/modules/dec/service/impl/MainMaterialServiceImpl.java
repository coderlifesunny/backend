package com.lifesunny.modules.dec.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.utils.Query;
import com.lifesunny.modules.dec.dao.MainMaterialDao;
import com.lifesunny.modules.dec.entity.MainMaterialEntity;
import com.lifesunny.modules.dec.service.MainMaterialService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mainMaterialService")
public class MainMaterialServiceImpl extends ServiceImpl<MainMaterialDao, MainMaterialEntity> implements MainMaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("limit", "100");//查询所有的，最多也并不会这么多
        Page<MainMaterialEntity> page = this.selectPage(
                new Query<MainMaterialEntity>(params).getPage(),
                new EntityWrapper<MainMaterialEntity>()
        );

        return new PageUtils(page);
    }

}
