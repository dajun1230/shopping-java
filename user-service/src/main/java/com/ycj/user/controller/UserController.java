package com.ycj.user.controller;

import com.ycj.common.utils.ResponseResult;
import com.ycj.user.pojo.User;
import com.ycj.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseResult userLogin() {
        return new ResponseResult(200, "登录成功");
    }

    @GetMapping("/list")
    @ApiOperation("查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true)
    })
    public ResponseResult queryUserList(
            @RequestParam("page") Integer page,
            @RequestParam("limit") Integer limit,
            @RequestParam("username") String username,
            @RequestParam("phoneNumber") String phoneNumber
            ) {
        List<User> userList = userService.queryUserList(page, limit, username, phoneNumber);
        int total = userService.getUserTotal();
        HashMap hashMap = new HashMap();
        hashMap.put("total", total);
        hashMap.put("data", userList);
        return new ResponseResult(200, "ok", hashMap);
    }

    @GetMapping("/query")
    @ApiOperation("查询单个用户")
    @ApiImplicitParam(paramType = "query", name="id", value = "用户ID", required = true)
    public ResponseResult getUser(@RequestParam("id") String id) {
        User user = userService.queryUserById(id);
        return new ResponseResult(200, "ok", user);
    }

    @PostMapping("/add")
    @ApiOperation("新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "body", name = "password", value = "密码", required = true),
            @ApiImplicitParam(paramType = "body", name = "sex", value = "性别"),
            @ApiImplicitParam(paramType = "body", name = "email", value = "邮箱"),
            @ApiImplicitParam(paramType = "body", name = "phoneNumber", value = "密码")
    })
    public ResponseResult addUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseResult(200, "ok");
    }

    @PutMapping("/update")
    @ApiOperation("更新用户")
    public ResponseResult updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseResult(200, "ok");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name="id", value = "用户ID", required = true)
    public ResponseResult deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return new ResponseResult(200, "ok");
    }

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody MultipartFile file) throws IOException {
        // 注意 前端传参的name要和MultipartFile的对象名保持一直 比如此处对象名为file 则前端传参的name也要为file
        // 获取上传文件的文件名
        String oldName = file.getOriginalFilename();
        // 指定上传路径
        String path="/Users/xiaoyang/Documents/yuanma/shopping-demo/shopping-java/images";
        // 拼接成为新文件的路径
        String filePath = path + oldName;
        //创建新文件对象 指定文件路径为拼接好的路径
        File newFile = new File(filePath);
        //将前端传递过来的文件输送给新文件 这里需要抛出IO异常 throws IOException
        file.transferTo(newFile);
        //上传完成后将文件路径返回给前端用作图片回显或增加时的文件路径值等
        return new ResponseResult(200, "成功", filePath);
    }
}
