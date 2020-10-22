package com.glg.shiroadmin.service.impl;

import com.glg.shiroadmin.entity.User;
import com.glg.shiroadmin.mapper.UserMapper;
import com.glg.shiroadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }
}
