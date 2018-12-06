package com.lifesunny.modules.sys.biz;

import com.lifesunny.modules.sys.entity.SysUserEntity;
import com.lifesunny.modules.sys.service.SysUserService;
import com.lifesunny.modules.sys.vo.SysUserDropdownVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 系统操作的复杂业务类
 *
 * @Author Guangcai.xu
 * @Date 2018/12/5 16:30
 */
@Component
public class SystemBiz {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询出所有的用户
     * @return
     */
    public List<SysUserDropdownVO> findAllUsers4Drowdown() {
        List<SysUserEntity> allUsers4Dropdown = sysUserService.getAllUsers4Dropdown();
        List<SysUserDropdownVO> vos = new ArrayList<>(allUsers4Dropdown.size());
        for (SysUserEntity entity : allUsers4Dropdown) {
            vos.add(new SysUserDropdownVO().build(entity));
        }
        return vos;
    }
}