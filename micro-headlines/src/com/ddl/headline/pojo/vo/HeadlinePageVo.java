package com.ddl.headline.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlinePageVo
 * Package: com.zhou.headline.pojo.vo
 * Description:
 *
 * @Author 豆豆龙
 * @Create 14/3/2024 下午1:35
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlinePageVo implements Serializable {
    private Integer hid;
    private String title;
    private Integer type;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
}