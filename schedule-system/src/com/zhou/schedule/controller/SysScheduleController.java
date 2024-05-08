package com.zhou.schedule.controller;

import com.zhou.schedule.common.Result;
import com.zhou.schedule.pojo.SysSchedule;
import com.zhou.schedule.service.SysScheduleService;
import com.zhou.schedule.service.impl.SysScheduleServiceImpl;
import com.zhou.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: SysScheduleController
 * Package: com.zhou.schedule.controller
 * Description:
 * 增加、查询、删除、修改 日程的请求
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:47
 */

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {

    private SysScheduleService sysScheduleService = new SysScheduleServiceImpl();

    /**
     * 根据sid 删除日程信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        sysScheduleService.removeSchedule(sid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    /**
     * 修改日程信息并保存
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求体中的JSON串 转换成一个sysSchedule对象
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        //调用服务层方法，将信息更新进入数据
        sysScheduleService.updateSchedule(schedule);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    /**
     * 增加一条空的日程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        //调用服务层方法，向数据库中增加一条空记录
        sysScheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));

    }

    /**
     * 查找用户的所有日程信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        //查询用户的所有日程信息
        List<SysSchedule> itemList = sysScheduleService.findItemListByUid(uid);

        //将用户的所有日常放入一个Result对象
        Map data = new HashMap();
        data.put("itemList",itemList);
        Result result = Result.ok(data);

        //将Result对象转换成json响应给客户端
        WebUtil.writeJson(resp,result);

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }

    //封装在BaseController里面
/*    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断此次请求是 增？删？改？查？
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];

*//*        if (methodName.equals("add")){
            add(req,resp);
        }else if (methodName.equals("find")){
            find(req,resp);
        } else if (methodName.equals("update")) {
            update(req,resp);
        } else if (methodName.equals("remove")) {
            remove(req,resp);
        }*//*


        //使用 反射 通过方法名获取下面的方法
        Class aClass = this.getClass();
        //获取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);

            //设置暴力破解方法的访问修饰符的限制
            declaredMethod.setAccessible(true);

            //执行方法
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}
