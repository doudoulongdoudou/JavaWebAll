package com.ddl.headline.service;

import com.ddl.headline.pojo.NewsUser;

/**
 * ClassName: NewsService
 * Package: com.zhou.headline.service
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:44
 */
public interface NewsUserService {
    /**
     * 根据用户登录的账号找用户的方法
     * @param username  用户输入的账号
     * @return  找到就返回NewsUser对象     失败就返回Null
     */
    NewsUser findByUsername(String username);

    /**
     * 根据用户id 找用户的方法
     * @param userId 用户的id
     * @return  找到就返回NewsUser对象     失败就返回Null
     */
    NewsUser findByUid(Integer userId);

    /**
     * 注册提交表单方法
     * @param registUser
     * @return
     */
    Integer registUser(NewsUser registUser);
}
