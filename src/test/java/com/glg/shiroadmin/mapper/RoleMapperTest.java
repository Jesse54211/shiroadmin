package com.glg.shiroadmin.mapper;

import com.glg.shiroadmin.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;
    @Test
    void testt(){
        User user = new User();
        user.setUsername("admin");
        roleMapper.findRoleByUser(user).forEach(System.out::println);
    }
}