package com.ycj.user.service.impl;

import com.ycj.user.mapper.UserMapper;
import com.ycj.user.pojo.User;
import com.ycj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList(int page, int limit, String username, String phoneNumber){
        int start = (page - 1) * limit;
        return userMapper.queryUserList(start, page * limit, username, phoneNumber);
    }

    @Override
    public User queryUserById(String id){
        return userMapper.queryUserById(id);
    }

    @Override
    public int createUser(User user){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        user.setId(uuid);
        user.setStatus(0);
        Long currentDate = new Date().getTime();
        user.setCreateUser(uuid);
        user.setCreateTime(currentDate);
        user.setUpdateUser(uuid);
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

    @Override
    public int getUserTotal(){
        int total = userMapper.getUserTotal();
        return total;
    }
}
