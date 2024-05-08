package com.zhou.schedule.service;

import com.zhou.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleService
 * Package: com.zhou.schedule.service
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:41
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
