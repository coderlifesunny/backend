package com.lifesunny.modules.sys.controller;

import com.lifesunny.common.annotation.SysLog;
import com.lifesunny.common.constants.Constant;
import com.lifesunny.common.entity.HttpResult;
import com.lifesunny.common.utils.PageUtils;
import com.lifesunny.common.validator.Assert;
import com.lifesunny.common.validator.ValidatorUtils;
import com.lifesunny.common.validator.group.AddGroup;
import com.lifesunny.common.validator.group.UpdateGroup;
import com.lifesunny.modules.sys.biz.SystemBiz;
import com.lifesunny.modules.sys.entity.SysUserEntity;
import com.lifesunny.modules.sys.form.PasswordForm;
import com.lifesunny.modules.sys.service.SysUserRoleService;
import com.lifesunny.modules.sys.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SystemBiz systemBiz;

    /**
     * 所有用户列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public HttpResult list(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }
        PageUtils page = sysUserService.queryPage(params);

        return HttpResult.ok().put("page", page);
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public HttpResult info() {
        return HttpResult.ok().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @PostMapping("/password")
    public HttpResult password(@RequestBody PasswordForm form) {
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();

        //更新密码
        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (!flag) {
            return HttpResult.error("原密码不正确");
        }

        return HttpResult.ok();
    }

    /**
     * 用户信息
     */
    @GetMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public HttpResult info(@PathVariable("userId") Long userId) {
        SysUserEntity user = sysUserService.selectById(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return HttpResult.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public HttpResult save(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return HttpResult.ok();
    }

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    public HttpResult update(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.update(user);

        return HttpResult.ok();
    }

    /**
     * 删除用户
     */
    @SysLog("删除用户")
    @PostMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public HttpResult delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return HttpResult.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return HttpResult.error("当前用户不能删除");
        }

        sysUserService.deleteBatch(userIds);

        return HttpResult.ok();
    }

    /**
     * 获取所有的用户，用于下拉框展示(暂时不加权限)
     *
     * @return
     */
    @GetMapping("/dropdown/users")
    public HttpResult findAllUsers4Dropdown() {
        return HttpResult.ok().put("users", systemBiz.findAllUsers4Drowdown());
    }
}
