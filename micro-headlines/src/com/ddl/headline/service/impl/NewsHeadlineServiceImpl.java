package com.ddl.headline.service.impl;

import com.ddl.headline.dao.NewsHeadlineDao;
import com.ddl.headline.dao.impl.NewsHeadlineDaoImpl;
import com.ddl.headline.pojo.NewsHeadline;
import com.ddl.headline.pojo.vo.HeadlineDetailVo;
import com.ddl.headline.pojo.vo.HeadlinePageVo;
import com.ddl.headline.pojo.vo.HeadlineQueryVo;
import com.ddl.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NewsHeadlineServiceImpl
 * Package: com.zhou.headline.service.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:46
 */
public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadlineDao headlineDao = new NewsHeadlineDaoImpl();

    @Override
    public Map findPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        List<HeadlinePageVo> pageData = headlineDao.findPageList(headlineQueryVo);
        int totalSize = headlineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize % pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
        Map pageInfo = new HashMap();
        pageInfo.put("pageData",pageData);
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);

        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        //修改头条的浏览量
        headlineDao.incrPageViews(hid);
        //修改头条的详情
        return headlineDao.findHeadlineDetail(hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return headlineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        return headlineDao.findByHid(hid);
    }

    @Override
    public int update(NewsHeadline newsHeadline) {
        return headlineDao.update(newsHeadline);
    }

    @Override
    public int removeHeadline(int hid) {
        return headlineDao.removeHeadline(hid);
    }
}
