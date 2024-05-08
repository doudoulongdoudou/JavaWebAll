package com.ddl.headline.test;

import com.ddl.headline.utils.JwtHelper;
import org.junit.Test;

/**
 * ClassName: TestJwtHelper
 * Package: com.ddl.headline.test
 * Description:
 * token测试
 * @Author 豆豆龙
 * @Create 14/3/2024 下午3:10
 */
public class TestJwtHelper {

    @Test
    public void testAllMethod() throws InterruptedException {
        String token = JwtHelper.createToken(1L);

        System.out.println(token);

        Long userId = JwtHelper.getUserId(token);

        System.out.println(userId);

        System.out.println(JwtHelper.isExpiration(token));

        Thread.sleep(6000);

        System.out.println(JwtHelper.isExpiration(token));
    }

}
