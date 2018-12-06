package com.lifesunny.common.enums;

import com.lifesunny.common.exception.ParamException;

/**
 * Description: 工地所处阶段枚举
 *
 * @Author Guangcai.xu
 * @Date 2018/12/6 16:26
 */
public enum ProjectStageEnum {
    CREATED(0, "未开工"),
    DOING(1, "施工中"),
    DONE(2, "已完工");

    private Integer value;
    private String name;

    ProjectStageEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ProjectStageEnum byValue(Integer value) {
        for (ProjectStageEnum e : ProjectStageEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static ProjectStageEnum byName(String name) {
        for (ProjectStageEnum e : ProjectStageEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}