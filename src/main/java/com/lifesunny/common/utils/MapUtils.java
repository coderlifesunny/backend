package com.lifesunny.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
