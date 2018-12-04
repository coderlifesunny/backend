package com.lifesunny.modules.sys.vo;

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
     * 角色列表
     */
    private List<String> roles;
}