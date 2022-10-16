package com.ycj.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxUser {
    private String encryptedData;
    private String sessionKey;
    private String iv;
}
