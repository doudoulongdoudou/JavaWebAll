package com.ddl.headline.controller;

import com.ddl.headline.common.Result;
import com.ddl.headline.pojo.NewsType;
import com.ddl.headline.pojo.vo.HeadlineDetailVo;
import com.ddl.headline.pojo.vo.HeadlineQueryVo;
import com.ddl.headline.service.NewsHeadlineService;
import com.ddl.headline.service.NewsTypeService;
import com.ddl.headline.service.impl.NewsHeadlineServiceImpl;
import com.ddl.headline.service.impl.NewsTypeServiceImpl;
import com.ddl.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: PortalController
 * Package: com.zhou.headline.controller
 * Description:
 * 门户控制器
 * 不需要登录，不需要crud的门户页的请求都放在这里
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:55
 */

@WebServlet("/portal/*")
public class PortalController extends BaseController{

    private NewsTypeService typeService = new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    /**
     * 查询所有头条类型的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<NewsType> newsTypeList = typeService.findAll();

        WebUtil.writeJson(resp,Result.ok(newsTypeList));
    }

    /**
     * 分页查询所有头条
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求参数
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        //将参数传递给服务层进行分页查询
        Map pageInfo = headlineService.findPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo",pageInfo);
        //将分页查询的结果转换成json响应给客户端
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 查询头条详情页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收要查询的头条的hid
        int hid = Integer.parseInt(req.getParameter("hid"));
        HeadlineDetailVo headlineDetailVo = headlineService.findHeadlineDetail(hid);
        Map data = new HashMap();
        data.put("headline",headlineDetailVo);
        WebUtil.writeJson(resp,Result.ok(data));

    }
}
