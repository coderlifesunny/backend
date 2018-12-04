package com.lifesunny.common.exception;

/**
 * Description: 参数异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = 3468002763310308893L;

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
