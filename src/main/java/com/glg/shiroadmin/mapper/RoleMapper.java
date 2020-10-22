package com.glg.shiroadmin.mapper;

import com.glg.shiroadmin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glg.shiroadmin.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
public interface RoleMapper extends BaseMapper<Role> {
//根据用户查询角色
    List<Role> findRoleByUser(@Param("user") User user);
}
