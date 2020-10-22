package com.glg.shiroadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 用户ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户名
     */
      private String username;

    private String nickname;

      /**
     * 邮箱
     */
      private String email;

      /**
     * 头像
     */
      private String avatar;

      /**
     * 联系电话
     */
      private String phoneNumber;

      /**
     * 性别 0男 1女 2保密
     */
      private Integer sex;

      /**
     * 状态 0锁定 1有效
     */
      private Integer status;

    private LocalDate birth;

      /**
     * 创建时间
     */
      private Date createTime;

      /**
     * 修改时间
     */
      private Date modifiedTime;

      /**
     * 0:超级管理员，1：系统用户
     */
      private Integer type;

      /**
     * 部门id
     */
      private Long departmentId;

      /**
     * 盐
     */
      private String salt;

      /**
     * 密码
     */
      private String password;

      /**
     * token
     */
      private String token;

      /**
     * 乐观锁
     */
      private Integer version;

      /**
     * 0正常，1 删除
     */
      private Integer deleted;


}
