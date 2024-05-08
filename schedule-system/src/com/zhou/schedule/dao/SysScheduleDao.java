package com.zhou.schedule.dao;

import com.zhou.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleDao
 * Package: com.zhou.schedule.dao
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午7:32
 */
public interface SysScheduleDao {

    /**
     * 用于向数据中增加一条日程记录
     * @param schedule
     * @return
     */
    int  addSchedule(SysSchedule schedule);

    /**
     * 查询所有用户的所有日程
     * @return
     */
    List<SysSchedule> findAll();

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
