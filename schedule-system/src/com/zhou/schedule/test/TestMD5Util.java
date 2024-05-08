package com.zhou.schedule.test;

import com.zhou.schedule.util.MD5Util;
import org.junit.Test;

/**
 * ClassName: TestMD5Util
 * Package: com.zhou.schedule.test
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 下午10:20
 */
public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
