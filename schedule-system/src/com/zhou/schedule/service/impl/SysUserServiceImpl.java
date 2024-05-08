package com.zhou.schedule.service.impl;

import com.zhou.schedule.dao.SysUserDao;
import com.zhou.schedule.dao.impl.SysUserDaoImpl;
import com.zhou.schedule.pojo.SysUser;
import com.zhou.schedule.service.SysUserService;
import com.zhou.schedule.util.MD5Util;

import java.util.List;

/**
 * ClassName: SysUserServiceImpl
 * Package: com.zhou.schedule.service.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:40
 */
public class SysUserServiceImpl implements SysUserService {

    private SysUserDao sysUserDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转换为密文密码
        String userPwd = sysUser.getUserPwd();
        String encrypt = MD5Util.encrypt(userPwd);
        sysUser.setUserPwd(encrypt);
        //调用Dao层方法 将sysUser信息存入数据库
        int rows = sysUserDao.addSysUser(sysUser);
        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser sysUser = sysUserDao.findByUsername(username);

        return sysUser;
    }
}
