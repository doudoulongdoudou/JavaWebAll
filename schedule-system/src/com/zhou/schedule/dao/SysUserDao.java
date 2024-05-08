package com.zhou.schedule.dao;

import com.zhou.schedule.pojo.SysUser;

/**
 * ClassName: SysUserDao
 * Package: com.zhou.schedule.dao
 * Description:
 * Data Access Object   数据访问对象
 *
 * Dao层一般需要定义接口和实现类
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午7:30
 */
public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser   要增加的记录的username和user_pwd字段以sysUser实体类对象的形式接受
     * @return  成功返回1， 失败返回0
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username  要查询的用户名
     * @return  找到返回sysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
