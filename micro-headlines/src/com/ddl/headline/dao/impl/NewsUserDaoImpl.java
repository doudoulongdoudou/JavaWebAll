package com.ddl.headline.dao.impl;

import com.ddl.headline.dao.BaseDao;
import com.ddl.headline.dao.NewsUserDao;
import com.ddl.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewsUserDaoImpl
 * Package: com.zhou.headline.dao.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:42
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUsername(String username) {
        String sql = "select uid, username, user_pwd userPwd, nick_name nickName from news_user where username = ?";
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        return newsUserList != null && newsUserList.size() > 0 ? newsUserList.get(0) : null;
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        String sql = """
                select 
                    uid, 
                    username, 
                    user_pwd userPwd, 
                    nick_name nickName 
                from 
                    news_user 
                where 
                    uid = ?
                """;
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, userId);
        return newsUserList != null && newsUserList.size() > 0 ? newsUserList.get(0) : null;
    }

    @Override
    public Integer insertUser(NewsUser registUser) {
        String sql = "insert into news_user values (DEFAULT, ?, ?, ?)";
        return baseUpdate(sql,registUser.getUsername(),registUser.getUserPwd(),registUser.getNickName());

    }

}
