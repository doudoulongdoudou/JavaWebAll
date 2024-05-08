package com.ddl.headline.service.impl;

import com.ddl.headline.dao.NewsTypeDao;
import com.ddl.headline.dao.impl.NewsTypeDaoImpl;
import com.ddl.headline.pojo.NewsType;
import com.ddl.headline.service.NewsTypeService;

import java.util.List;

/**
 * ClassName: NewsHeadlineServiceImpl
 * Package: com.zhou.headline.service.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:46
 */
public class NewsTypeServiceImpl implements NewsTypeService {

    private NewsTypeDao typeDao = new NewsTypeDaoImpl();

    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
