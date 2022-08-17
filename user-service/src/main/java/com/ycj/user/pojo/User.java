package com.ycj.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    private String id;
    private String username;
    private String password;
    private int status;
    private String email;
    private String phoneNumber;
    private int sex;
    private String avatar;
    private String userType;
}
