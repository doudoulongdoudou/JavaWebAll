package com.ddl.headline.service;

import com.ddl.headline.pojo.NewsHeadline;
import com.ddl.headline.pojo.vo.HeadlineDetailVo;
import com.ddl.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * ClassName: NewsService
 * Package: com.zhou.headline.service
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:44
 */
public interface NewsHeadlineService {
    /**
     * 分页查询头条信息
     * @param headlineQueryVo
     * @return
     */
    Map findPage(HeadlineQueryVo headlineQueryVo);

    /**
     * 查询头条详情的方法
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     * 发布新闻
     * @param newsHeadline
     */
    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 根据hid查找头条信息 修改
     * @param hid
     * @return
     */
    NewsHeadline findHeadlineByHid(Integer hid);

    /**
     * 保存修改头条信息方法
     * @param newsHeadline
     * @return
     */
    int update(NewsHeadline newsHeadline);

    /**
     * 删除头条信息方法
     * @param hid
     * @return
     */
    int removeHeadline(int hid);
}
