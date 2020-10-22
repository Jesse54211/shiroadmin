package com.glg.shiroadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色菜单关联表
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_role_menu")
public class Role_menu implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 角色ID
     */
      private Long roleId;

      /**
     * 菜单/按钮ID
     */
      private Long menuId;


}
