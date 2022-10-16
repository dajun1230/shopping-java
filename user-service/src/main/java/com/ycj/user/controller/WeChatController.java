package com.ycj.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.ycj.common.utils.HttpUtil;
import com.ycj.common.utils.ResponseResult;
import com.ycj.user.pojo.WxUser;
import com.ycj.user.utils.WeChatUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wechat")
public class WeChatController {
    private static String appId = "wx162facaf75498695";
    private static String secret = "f561119f04a0792b7ed8438b46675eeb";

    @GetMapping("/code")
    public String getWechatCode(@RequestParam("code") String code) {
        // https://api.weixin.qq.com/sns/jscode2session?appid=${appId}&secret=${secret}&js_code=${code}&grant_type=authorization_code
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String val = HttpUtil.doGet(url);
        System.out.println("请求返回的参数" + val);
        return "";
    }

    @GetMapping("/accessToken")
    public ResponseResult getAccessToken() {
        // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
        String response = HttpUtil.doGet(url);
        System.out.println("请求返回的参数accesstoken" + response);
        return new ResponseResult(200, "", response);
    }

    @GetMapping("/token") // 接口未通
    public String getWechatToken(@RequestParam("code") String code) {
        // https://api.weixin.qq.com/sns/oauth2/access_token?appid=${appId}&secret=${secret}&code=${code}&grant_type=authorization_code
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        String val = HttpUtil.doGet(url);
        System.out.println("请求返回的参数token" + val);
        return "";
    }

    @PostMapping("/decrypt")
    public ResponseResult decryptUserInfo(@RequestBody WxUser decryptInfo) {
        String encryptedData = decryptInfo.getEncryptedData();
        String sessionKey = decryptInfo.getSessionKey();
        String iv = decryptInfo.getIv();
        JSONObject userinfo = WeChatUtils.decryptUserInfo(encryptedData, "PdAzxF9UueFJPTJ0m2m0ow==", iv);
        System.out.println("用户信息：" + userinfo);
        return  new ResponseResult(200, "", userinfo);
    }
}
