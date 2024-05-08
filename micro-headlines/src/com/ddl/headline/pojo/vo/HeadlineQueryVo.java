package com.ddl.headline.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlineQueryVo
 * Package: com.zhou.headline.pojo.vo
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:32
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineQueryVo implements Serializable {
    private String keyWords;
    private Integer type;
    private Integer pageNum;
    private Integer pageSize;
}
