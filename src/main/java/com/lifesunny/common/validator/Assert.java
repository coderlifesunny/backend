package com.lifesunny.common.validator;

import com.lifesunny.common.exception.SystemException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new SystemException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new SystemException(message);
        }
    }
}
