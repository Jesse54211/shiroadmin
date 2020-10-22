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
 * 
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 名
     */
      private String name;

      /**
     * 部门办公电话
     */
      private String phone;

      /**
     * 办公室地点
     */
      private String address;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 修改时间
     */
      private LocalDateTime modifiedTime;


}
