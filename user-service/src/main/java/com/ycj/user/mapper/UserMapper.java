package com.ycj.user.mapper;

import com.ycj.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserList(int page, int limit, String username, String phoneNumber);
    User queryUserById(String id);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
    int getUserTotal();
}
