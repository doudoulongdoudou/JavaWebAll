package com.zhou.schedule.service.impl;

import com.zhou.schedule.dao.SysScheduleDao;
import com.zhou.schedule.dao.impl.SysScheduleDaoImpl;
import com.zhou.schedule.pojo.SysSchedule;
import com.zhou.schedule.service.SysScheduleService;

import java.util.List;

/**
 * ClassName: SysScheduleServiceImpl
 * Package: com.zhou.schedule.service.impl
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:42
 */
public class SysScheduleServiceImpl implements SysScheduleService {

    private SysScheduleDao scheduleDao = new SysScheduleDaoImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return scheduleDao.removeSchedule(sid);
    }
}
