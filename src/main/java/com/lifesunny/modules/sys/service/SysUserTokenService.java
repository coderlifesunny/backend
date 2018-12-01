package com.lifesunny.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	HttpResult createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
