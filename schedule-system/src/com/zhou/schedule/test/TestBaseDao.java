package com.zhou.schedule.test;

import com.zhou.schedule.dao.BaseDao;
import com.zhou.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * ClassName: TestBaseDao
 * Package: com.zhou.schedule.test
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午8:24
 */
public class TestBaseDao {

    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }

    //查询用户数量
    @Test
    public void testBaseQueryObject(){
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
//        for (Object o : sysUserList){
//            System.out.println(o);
//        }
    }

    @Test
    public void testBaseUpade(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql,1, "学习Java", 0);
        System.out.println(rows);
    }

}
