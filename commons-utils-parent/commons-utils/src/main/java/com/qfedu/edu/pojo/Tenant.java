package com.qfedu.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/*
* @Author：当归 👨‍🦰❤️‍🩹️‍👧
* @Date：2024/6/22
* @serviceLogic: 租户表
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("qf_tenant")
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 租户用户名
     */
    private String name;

    /**
     * 租户密码
     */
    private String pwd;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司工商执照编码
     */
    private String companyCode;

    /**
     * 是否可用, 1可用, 2不可用
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
     * 逻辑删标识  0未删除  1删除
     */
    private Integer deleted;

    /**
     * 租户key
     */
    private String accessKey;

    /**
     * 租户秘钥
     */
    private String accessSecurit;

    /**
     * 审核状态,0待审核, 1通过, 2不通过
     */
    private Integer auditStatus;

    /**
     * 租户手机号
     */
    private String phone;


}
