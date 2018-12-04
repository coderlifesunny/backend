package com.lifesunny.common.enums;

import com.lifesunny.common.exception.ParamException;

/**
 * Description: 有效无效标签
 *
 * @Author Guangcai.xu
 * @Date 2018/10/31 17:16
 */
public enum StateEnum {
    ENABLE(1, "正常"),
    DISABLE(0, "禁用");

    private Integer value;
    private String name;

    StateEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static StateEnum byValue(Integer value) {
        for (StateEnum e : StateEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static StateEnum byName(String name) {
        for (StateEnum e : StateEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}
