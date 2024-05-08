package com.ddl.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsType
 * Package: com.zhou.headline.pojo
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:24
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsType implements Serializable {
    private Integer tid;
    private String tname;
}
