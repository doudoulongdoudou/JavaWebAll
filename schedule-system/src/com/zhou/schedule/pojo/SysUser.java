package com.zhou.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * ClassName: SysUser
 * Package: com.zhou.schedule.pojo
 * Description:
 * 1.每个属性必须是私有的
 * 2.必须具备无参构造器
 * 3.每个属性都必须具备getter and setter
 * 4.应该实现序列化接口（缓存  分布式项目数据传递  可能会将对象序列化）
 * 5.应该重写类的 hashcode 和 equals 方法
 * 6.toString是否重写都可以
 * 7.实体类的类名和表格名称应该对应    （对应并不是一致）
 * 8.实体类的属性名和表格的列名应该对应    （对应并不是一致）
 *
 * 使用lombok生成
 *
 * @Author 豆豆龙
 * @Create 4/3/2024 上午10:20
 */

@AllArgsConstructor     //添加了全参构造
@NoArgsConstructor      //添加了无参构造
@Data                   //getter setter  hashcode和equals  toString
public class SysUser {

    private Integer uid;
    private String username;
    private String userPwd;

/*    public SysUser() {
    }

    public SysUser(Integer uid, String username, String userPwd) {
        this.uid = uid;
        this.username = username;
        this.userPwd = userPwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(userPwd, sysUser.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
    */
}
