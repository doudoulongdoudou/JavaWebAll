package com.ddl.headline.common;

/**
 * ClassName: ResultCodeEnum
 * Package: com.zhou.headline.common
 * Description:
 * 统一返回结果状态信息类
 * @Author 豆豆龙
 * @Create 14/3/2024 下午12:31
 */

public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed")
    ;

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
