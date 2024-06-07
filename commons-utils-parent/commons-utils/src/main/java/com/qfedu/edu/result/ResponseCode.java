package com.qfedu.edu.result;

/**
 * @author 当归
 * @title: ResponseCode
 * @projectName CD-Java-JY-2401-Simple-Parent
 * @description: 这个是异常信息的枚举
 * @date 2024/4/15  14:10
 */
public enum ResponseCode {
    SUCCESS(0, "请求成功"),
    PARAMETER_EXCEPTION(100, "参数有误"),
    USERNAME_PASSWORD_EXCEPTION(101, "用户名或者密码不对"),
    PASSWORD_EXCEPTION(102, "密码不对"),
    SYSTEM_EXCEPTION(103, "系统异常"),
    SQL_EXCEPTION(105, "SQL异常"),
    USER_MANY_EXCEPTION(104, "用户信息已经存在不能添加"),
    USERNAME_PASSWORD_EMPTY_EXCEPTION(106, "用户名和密码不能为空"),
    AUTHENTICATION_EXCEPTION(107, "身份认证失败"),
    NO_PERMISSION_EXCEPTION(403, "没有权限访问"),
    FAIL(-1, "请求失败");
    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
