package com.glg.shiroadmin.mapper;

import com.glg.shiroadmin.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glg.shiroadmin.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 * @author Jesse
 * @since 2020-10-22
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //根据角色名查权限
    List<Menu> findPermissionByRole(@Param("role") Role role);

}
