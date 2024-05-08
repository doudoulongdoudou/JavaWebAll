package com.zhou.schedule.service;

import com.zhou.schedule.pojo.SysUser;

/**
 * ClassName: SysUserService
 * Package: com.zhou.schedule.service
 * Description:
 * 该接口对定义了以sys_user表格为核心的业务处理功能
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:38
 */
public interface SysUserService {

    /**
     * 注册用户的方法，
     * @param sysUser   要注册的用户名和明文密码以SysUser对象的形式接收
     * @return  注册成功返回1，失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username  要查询的用户名
     * @return  找到返回sysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
