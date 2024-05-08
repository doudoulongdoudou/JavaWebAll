package com.zhou.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: SysSchedule
 * Package: com.zhou.schedule.pojo
 * Description:
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 上午10:44
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private  Integer uid;
    private String title;
    private  Integer completed;

}
