package com.lifesunny.common.enums;

import com.lifesunny.common.exception.ParamException;

/**
 * Description: 参数异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public enum YesNoEnum {
    YES(1, "是"),
    NO(0, "否");
    private Integer value;
    private String name;

    YesNoEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static YesNoEnum byValue(Integer value) {
        for (YesNoEnum e : YesNoEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static YesNoEnum byName(String name) {
        for (YesNoEnum e : YesNoEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}
