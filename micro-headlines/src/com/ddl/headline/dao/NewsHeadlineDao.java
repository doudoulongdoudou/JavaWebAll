package com.ddl.headline.dao;

import com.ddl.headline.pojo.NewsHeadline;
import com.ddl.headline.pojo.vo.HeadlineDetailVo;
import com.ddl.headline.pojo.vo.HeadlinePageVo;
import com.ddl.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
 * ClassName: NewsHeadlineDao
 * Package: com.zhou.headline.dao
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:40
 */
public interface NewsHeadlineDao {

    /**
     * 查找pageData信息
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     * 计算新闻总数量
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     * 修改浏览量
     * @param hid
     * @return
     */
    int incrPageViews(int hid);

    /**
     * 查询头条详细内容
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     * 发布新闻
     * @param newsHeadline
     * @return
     */
    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 根据hid查找头条信息 修改
     * @param hid
     * @return
     */
    NewsHeadline findByHid(Integer hid);

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
