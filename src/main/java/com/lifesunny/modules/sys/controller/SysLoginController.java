package com.lifesunny.modules.sys.controller;

import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.modules.sys.entity.SysUserEntity;
import com.lifesunny.modules.sys.form.SysLoginForm;
import com.lifesunny.modules.sys.service.SysCaptchaService;
import com.lifesunny.modules.sys.service.SysUserService;
import com.lifesunny.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录相关
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@RestController
public class SysLoginController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;
	@Autowired
	private SysCaptchaService sysCaptchaService;

	/**
	 * 验证码
	 */
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, String uuid)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//获取图片验证码
		BufferedImage image = sysCaptchaService.getCaptcha(uuid);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@PostMapping("/sys/login")
	public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {
		boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
		if(!captcha){
			return HttpResult.error("验证码不正确");
		}

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
			return HttpResult.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return HttpResult.error("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
		HttpResult httpResult = sysUserTokenService.createToken(user.getUserId());
		return httpResult;
	}


	/**
	 * 退出
	 */
	@PostMapping("/sys/logout")
	public HttpResult logout() {
		sysUserTokenService.logout(getUserId());
		return HttpResult.ok();
	}
	
}
