package com.ycj.user.service;

import com.ycj.user.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryUserList(int page, int limit, String username, String phoneNumber);
    User queryUserById(String id);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
    int getUserTotal();
}
