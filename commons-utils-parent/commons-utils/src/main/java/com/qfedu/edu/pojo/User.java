package com.qfedu.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员用户表
 * </p>
 *
 * @author xiaobobo
 * @since 2024-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("qf_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实名字
     */
    private String realName;

    /**
     * 用户名，需要加密存储，可用于登录
     */
    private String userName;

    /**
     * 密码，需要加密存储
     */
    private String password;

    /**
     * 手机号，需要加密存储，可用于登录
     */
    private Integer phone;

    /**
     * 邮箱，需要加密存储，可用于登录
     */
    private String email;

    /**
     * 是否可用,1可用,2不可用
     */
    private Integer enable;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删标识
     */
    private Integer deleted;


}
