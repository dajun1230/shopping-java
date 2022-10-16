package com.ycj.user;

import com.ycj.user.mapper.UserMapper;
import com.ycj.user.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUser {

    @Autowired
    UserMapper userMapper;

    @Test
    void getPage() {
        int total = userMapper.getUserTotal();
        System.out.println("total:" + total);
    }

    @Test
    void getUserList() {
        List<User> userList = userMapper.queryUserList(1, 10, "", "");
        System.out.println(userList);
    }
}
