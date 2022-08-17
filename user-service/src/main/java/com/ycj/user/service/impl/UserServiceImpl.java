package com.ycj.user.service.impl;

import com.ycj.user.mapper.UserMapper;
import com.ycj.user.pojo.User;
import com.ycj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(String id){
        return userMapper.queryUserById(id);
    }

    @Override
    public int createUser(User user){
        Long currentDate = new Date().getTime();
        user.setCreateTime(currentDate);
        user.setUpdateTime(currentDate);
        return userMapper.createUser(user);
    }

    @Override
    public int updateUser(User user){
        Long currentDate = new Date().getTime();
        user.setUpdateTime(currentDate);
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(String id){
        return userMapper.deleteUserById(id);
    }
}
