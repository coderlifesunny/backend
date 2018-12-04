package com.lifesunny.modules.sys.vo;

import com.lifesunny.common.enums.StateEnum;
import com.lifesunny.modules.sys.entity.SysUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Description: 用户下拉选择框对象
 *
 * @Author Guangcai.xu
 * @Date 2018/12/4 13:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserDropdownVO {

    private Long userId;

    private String username;

    private boolean disabled = false;

    public SysUserDropdownVO build(SysUserEntity entity) {
        BeanUtils.copyProperties(entity, this);
        this.setDisabled(StateEnum.byValue(entity.getStatus()) == StateEnum.DISABLE);
        return this;
    }
}