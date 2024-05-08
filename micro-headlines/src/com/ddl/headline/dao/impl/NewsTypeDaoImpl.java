package com.ddl.headline.dao.impl;

import com.ddl.headline.dao.BaseDao;
import com.ddl.headline.dao.NewsTypeDao;
import com.ddl.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDaoImpl
 * Package: com.zhou.headline.dao.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:42
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    @Override
    public List<NewsType> findAll() {
        String sql = "select tid, tname from news_type";
        return baseQuery(NewsType.class, sql);
    }
}
