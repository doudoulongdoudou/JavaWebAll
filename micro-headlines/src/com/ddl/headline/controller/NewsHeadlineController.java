package com.ddl.headline.controller;

import com.ddl.headline.common.Result;
import com.ddl.headline.pojo.NewsHeadline;
import com.ddl.headline.service.NewsHeadlineService;
import com.ddl.headline.service.impl.NewsHeadlineServiceImpl;
import com.ddl.headline.utils.JwtHelper;
import com.ddl.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NewsHeadlineController
 * Package: com.zhou.headline.controller
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:51
 */

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    /**
     * 发布头条的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Long userId = JwtHelper.getUserId(token);

        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadline.setPublisher(userId.intValue());

        headlineService.addNewsHeadline(newsHeadline);

        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     * 根据hid修改头条回显业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));

        NewsHeadline headline = headlineService.findHeadlineByHid(hid);
        Map data = new HashMap();
        data.put("headline",headline);
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 保存修改头条的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        headlineService.update(newsHeadline);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    /**
     * 删除头条信息的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));

        headlineService.removeHeadline(hid);

        WebUtil.writeJson(resp,Result.ok(null));

    }
}
