
package com.lifesunny.modules.sys.form;

/**
 * 密码表单
 *
 * @Author Guangcai.xu
 * @Date 2018/11/29 11:14
 */
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
