package com.ddl.headline.controller;

/**
 * ClassName: NewsUserController
 * Package: com.zhou.headline.controller
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:53
 */

import com.ddl.headline.common.Result;
import com.ddl.headline.common.ResultCodeEnum;
import com.ddl.headline.pojo.NewsUser;
import com.ddl.headline.service.NewsUserService;
import com.ddl.headline.service.impl.NewsUserServiceImpl;
import com.ddl.headline.utils.JwtHelper;
import com.ddl.headline.utils.MD5Util;
import com.ddl.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    private NewsUserService userService = new NewsUserServiceImpl();

    /**
     * 处理登录表单提交的业务接口的实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名和密码
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);

        //调用服务层方法 实现登录
        NewsUser loginUser = userService.findByUsername(paramUser.getUsername());
        Result result = null;
        if (null != loginUser) {
            //equalsIgnoreCase  比较不区分大小写
            if (MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())) {
                Integer uid = loginUser.getUid();
                String token = JwtHelper.createToken(uid.longValue());
                //把token装在map里
                Map data = new HashMap();
                data.put("token",token);
                result = Result.ok(data);
            }else {
                result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //向客户端响应登录验证信息
        WebUtil.writeJson(resp, result);
    }

    /**
     * 根据token口令获得用户信息的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求中的token
        String token = req.getHeader("token");
        //校验token
        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if (null != token && !"".equals(token)){

            if (!JwtHelper.isExpiration(token)) {
                Integer userId = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser = userService.findByUid(userId);
                if (null !=newsUser){
                    //通过校验
                    Map data = new HashMap();
                    //密码置空
                    newsUser.setUserPwd("");
                    data.put("loginUser",newsUser);
                    result = Result.ok(data);
                }
            }
        }

        //向客户端响应信息
        WebUtil.writeJson(resp, result);
    }

    /**
     * 用户注册时输入用户名，校验用户名是否可用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        NewsUser newsUser = userService.findByUsername(username);
        Result result = Result.ok(null);
        if (null != newsUser){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);
    }

    /**
     * 完成注册的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser registUser = WebUtil.readJson(req, NewsUser.class);
        Integer rows = userService.registUser(registUser);

        Result result = Result.ok(null);
        if (rows == 0){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 前端自己校验是否失去登录状态的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");

        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if (null != token){
            if (!JwtHelper.isExpiration(token)){
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(resp,result);
    }
}
