package com.lifesunny.modules.sys.vo;

import com.lifesunny.common.enums.UserTitleEnum;
import com.lifesunny.modules.sys.entity.SysUserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description: 用户VO
 *
 * @Author Guangcai.xu
 * @Date 2018/12/3 16:54
 */
@Data
@NoArgsConstructor
public class SysUserVO extends SysUserEntity {

    /**
     * 岗位名称
     */
    private String titleName;

    /**
     * 角色列表
     */
    private List<String> roles;

    public String getTitleName() {
        return UserTitleEnum.byValue(this.getTitle()).getName();
    }
}