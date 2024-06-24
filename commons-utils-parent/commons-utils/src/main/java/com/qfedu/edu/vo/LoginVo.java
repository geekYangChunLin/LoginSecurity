package com.qfedu.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：当归
 * @description: 管理员登陆
 * @Date：2024/6/22 下午9:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {

    //用户名
    private String username;
    //密码
    private String password;

    // 0: 表示是管理员登陆  1：表示是租户登陆
    private Integer type;
}
