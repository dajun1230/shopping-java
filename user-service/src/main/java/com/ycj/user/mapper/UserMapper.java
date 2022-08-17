package com.ycj.user.mapper;

import com.ycj.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User queryUserById(String id);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(String id);
}
