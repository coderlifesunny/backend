package com.lifesunny.common.exception;

import com.lifesunny.common.entity.HttpResult;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 * 
 * @author chenshun
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(SystemException.class)
	public HttpResult handleRRException(SystemException e){
		HttpResult httpResult = new HttpResult();
		httpResult.put("code", e.getCode());
		httpResult.put("msg", e.getMessage());

		return httpResult;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public HttpResult handlerNoFoundException(Exception e) {
		logger.error(e.getMessage(), e);
		return HttpResult.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public HttpResult handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return HttpResult.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public HttpResult handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return HttpResult.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public HttpResult handleException(Exception e){
		logger.error(e.getMessage(), e);
		return HttpResult.error();
	}
}
