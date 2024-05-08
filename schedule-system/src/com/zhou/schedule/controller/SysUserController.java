package com.zhou.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.schedule.common.Result;
import com.zhou.schedule.common.ResultCodeEnum;
import com.zhou.schedule.pojo.SysUser;
import com.zhou.schedule.service.SysUserService;
import com.zhou.schedule.service.impl.SysUserServiceImpl;
import com.zhou.schedule.util.MD5Util;
import com.zhou.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SysUserController
 * Package: com.zhou.schedule.controller
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:45
 */

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService  sysUserService = new SysUserServiceImpl();

    /**
     * 就收用户注册请求的业务处理方法（业务接口   此处不是指interface）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收客户端提交的参数
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");

        //接受提交的json参数，并转换为User对象，获取信息
        SysUser registUser = WebUtil.readJson(req, SysUser.class);



        //2.调用服务层方法，完成注册
            //将参数放入SysUser对象中，在调用regist方法时传入

        int rows = sysUserService.regist(registUser);

        //3.根据注册的结果（成功or失败）做页面的跳转
        Result result = Result.ok(null);
        if (rows <1){
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接收用户登录请求的业务处理方法（业务接口   此处不是指interface）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受用户名和密码
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");

        SysUser sysUser = WebUtil.readJson(req, SysUser.class);

        //2.调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = sysUserService.findByUsername(sysUser.getUsername());
        Result result = Result.ok(null);
        if (null == loginUser){
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }else if (!MD5Util.encrypt(sysUser.getUserPwd()).equals(loginUser.getUserPwd())) {
            result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else {
            //登陆成功，将用户uid和username响应给客户端
            Map data = new HashMap();
            //置空密码，保证密码安全
            loginUser.setUserPwd("");
            data.put("loginUser",loginUser);

            result = Result.ok(data);
        }

        //3.将登录结果响应给客户端
        WebUtil.writeJson(resp,result);

    }

    /**
     * 注册时，接收要注册的用户名，校验用户名是否被占用的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名
        String username = req.getParameter("username");

        //调用服务层业务处理方法查询该用户用户名是否有对应的用户
        SysUser sysUser = sysUserService.findByUsername(username);

        //如果有   响应已占用
        //如果没有    响应可用

        Result result = Result.ok(null);

//        String info = "可用";
        if (null != sysUser){
//            info = "已占用";
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
/*        //将result对象转换为json串响应给客户端
        //ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String info = objectMapper.writeValueAsString(result);
        //告诉客户端响应给你的是一个JSON串
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(info);*/
        WebUtil.writeJson(resp,result);



    }
}
