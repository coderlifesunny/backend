package com.lifesunny.common.enums;

import com.lifesunny.common.exception.ParamException;

/**
 * Description: 用户岗位枚举，暂时枚举表示
 *
 * @Author Guangcai.xu
 * @Date 2018/12/7 9:39
 */
public enum UserTitleEnum {
    SUPER_ADMIN(-2, "超级管理员"),
    SYSTEM_MANAGER(-1, "系统管理员"),
    DESIGNER(0, "设计师"),
    PROJECT_MANAGER(1, "项目经理"),
    MATERIAL_MANAGER(2, "材料管理员"),
    HR(3, "人事"),
    BOSS(4, "BOSS");

    private Integer value;
    private String name;

    UserTitleEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static UserTitleEnum byValue(Integer value) {
        for (UserTitleEnum e : UserTitleEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static UserTitleEnum byName(String name) {
        for (UserTitleEnum e : UserTitleEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

}