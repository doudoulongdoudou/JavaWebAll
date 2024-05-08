package com.ddl.headline.service.impl;

import com.ddl.headline.dao.NewsUserDao;
import com.ddl.headline.dao.impl.NewsUserDaoImpl;
import com.ddl.headline.pojo.NewsUser;
import com.ddl.headline.service.NewsUserService;
import com.ddl.headline.utils.MD5Util;

/**
 * ClassName: NewsHeadlineServiceImpl
 * Package: com.zhou.headline.service.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:46
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao userDao = new NewsUserDaoImpl();
    @Override
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser registUser) {
        //处理增加数据的业务
        //将明文密码转换成密文密码
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));
        return userDao.insertUser(registUser);
    }


}
