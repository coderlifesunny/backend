package com.lifesunny.common.entity;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public class HttpResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public HttpResult() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static HttpResult error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static HttpResult error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static HttpResult error(int code, String msg) {
		HttpResult httpResult = new HttpResult();
		httpResult.put("code", code);
		httpResult.put("msg", msg);
		return httpResult;
	}

	public static HttpResult ok(String msg) {
		HttpResult httpResult = new HttpResult();
		httpResult.put("msg", msg);
		return httpResult;
	}
	
	public static HttpResult ok(Map<String, Object> map) {
		HttpResult httpResult = new HttpResult();
		httpResult.putAll(map);
		return httpResult;
	}
	
	public static HttpResult ok() {
		return new HttpResult();
	}

	public HttpResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
