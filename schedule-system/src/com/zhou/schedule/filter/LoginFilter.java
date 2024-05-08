package com.zhou.schedule.filter;

import com.zhou.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: com.zhou.schedule.filter
 * Description:
 *
 * @Author 豆豆龙
 * @Create 6/3/2024 下午10:18
 */

//@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获得session域对象
        HttpSession session = request.getSession();

        //从session域中获得登录的用户对象
        Object sysUser = session.getAttribute("sysUser");

        //判断用户对象是否为空
        if (sysUser ==null){
            //没登录 跳到login.html
            response.sendRedirect("/login.html");
        }else {
            //登录过就放行
            filterChain.doFilter(request,response);
        }



    }
}
