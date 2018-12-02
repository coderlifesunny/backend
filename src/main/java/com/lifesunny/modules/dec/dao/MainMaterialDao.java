package com.lifesunny.modules.dec.dao;

import com.lifesunny.modules.dec.entity.MainMaterialEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 主要材料表，有多种类型，硬材，软材，辅材，其他
 * 
 * @author guangcai.xu
 * @email coderlifesunny@126.com
 * @date 2018-12-02 15:46:28
 */
@Mapper
public interface MainMaterialDao extends BaseMapper<MainMaterialEntity> {
	
}
