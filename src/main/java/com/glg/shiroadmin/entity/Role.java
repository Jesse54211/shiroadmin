package com.glg.shiroadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 角色ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 角色名称
     */
      private String roleName;

      /**
     * 角色描述
     */
      private String remark;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 修改时间
     */
      private LocalDateTime modifiedTime;

      /**
     * 是否可用,0:不可用，1：可用
     */
      private Integer status;


}
