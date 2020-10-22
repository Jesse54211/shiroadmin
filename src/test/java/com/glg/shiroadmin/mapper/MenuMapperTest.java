package com.glg.shiroadmin.mapper;

import com.glg.shiroadmin.entity.Menu;
import com.glg.shiroadmin.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void test(){
        Role role = new Role();
        role.setRoleName("超级管理员");
        menuMapper.findPermissionByRole(role).forEach(System.out::println);
    }

}