package com.lifesunny.common.enums;

import com.lifesunny.common.exception.ParamException;

/**
 * Description: 调用info接口的类型
 *
 * @Author Guangcai.xu
 * @Date 2018/12/6 14:28
 */
public enum InfoTypeEnum {
    VIEW(0, "查看"),
    MODIFY(1, "修改");

    private Integer value;
    private String name;

    InfoTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static InfoTypeEnum byValue(Integer value) {
        for (InfoTypeEnum e : InfoTypeEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static InfoTypeEnum byName(String name) {
        for (InfoTypeEnum e : InfoTypeEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}
