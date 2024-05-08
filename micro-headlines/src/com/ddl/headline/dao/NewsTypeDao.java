package com.ddl.headline.dao;

import com.ddl.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDao
 * Package: com.zhou.headline.dao
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:40
 */
public interface NewsTypeDao {

    /**
     * 查询所有头条类型的方法
     * @return  多个头条类型以List<NewsType>集合形式返回
     */
    List<NewsType> findAll();
}
