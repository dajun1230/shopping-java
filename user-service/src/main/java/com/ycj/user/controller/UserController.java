package com.ycj.user.controller;

import com.ycj.common.utils.ResponseResult;
import com.ycj.user.pojo.User;
import com.ycj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public ResponseResult getUser(@RequestParam("id") String id) {
        User user = userService.queryUserById(id);
        return new ResponseResult(200, "ok", user);
    }

    @PostMapping("/add")
    public ResponseResult addUser(@RequestBody User user) {
        System.out.println("user:" + user);
        userService.createUser(user);
        return new ResponseResult(200, "ok");
    }

    @PutMapping("/update")
    public ResponseResult updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseResult(200, "ok");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return new ResponseResult(200, "ok");
    }
}
