package com.lifesunny.common.exception;

/**
 * 自定义异常
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public SystemException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public SystemException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public SystemException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public SystemException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
