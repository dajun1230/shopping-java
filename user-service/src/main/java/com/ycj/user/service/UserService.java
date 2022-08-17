package com.ycj.user.service;

import com.ycj.user.pojo.User;

public interface UserService {
    User queryUserById(String id);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
}
