package com.glg.shiroadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_user_role")
public class User_role implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 用户ID
     */
      private Long userId;

      /**
     * 角色ID
     */
      private Long roleId;


}
