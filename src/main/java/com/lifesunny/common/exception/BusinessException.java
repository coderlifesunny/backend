package com.lifesunny.common.exception;

/**
 * Description: 业务异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2630618177937698486L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
