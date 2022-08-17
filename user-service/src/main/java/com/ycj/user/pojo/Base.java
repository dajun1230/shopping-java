package com.ycj.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    private String createUser;
    private Long createTime;
    private String updateUser;
    private Long updateTime;
}
