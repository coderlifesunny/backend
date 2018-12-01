package com.lifesunny.common.utils;

/**
 * Redis所有Keys
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
