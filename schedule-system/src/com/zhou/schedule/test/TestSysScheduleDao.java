package com.zhou.schedule.test;

import com.zhou.schedule.dao.SysScheduleDao;
import com.zhou.schedule.dao.impl.SysScheduleDaoImpl;
import com.zhou.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: TestSysScheduleDao
 * Package: com.zhou.schedule.test
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午9:17
 */
public class TestSysScheduleDao {

    private static SysScheduleDao scheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        scheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void TestAddSchedule() {
        int rows = scheduleDao.addSchedule(new SysSchedule(null, 2, "学习JavaWeb", 1));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> scheduleList = scheduleDao.findAll();
        scheduleList.forEach(System.out::println);
    }

}
