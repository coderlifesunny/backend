package com.lifesunny.modules.dec.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.utils.Query;
import com.lifesunny.modules.dec.dao.ProjectDao;
import com.lifesunny.modules.dec.entity.ProjectEntity;
import com.lifesunny.modules.dec.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                new EntityWrapper<ProjectEntity>()
                        .like("name", (String) params.get("name"))
                        .like("designer_name", (String) params.get("designerName"))
                        .like("manager_name", (String) params.get("managerName"))
                        .eq(!(params.get("status")).equals("-999"), "status", params.get("status"))
        );

        return new PageUtils(page);
    }

}
