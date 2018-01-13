package com.example.demo.controller;

import com.example.demo.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wechat")
public class WechatController {
    @Autowired
    private WeChatService weChatService;

    private String token = "2018zhongwubaiwan";
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public String wechatValidate(@RequestParam(value = "signature", required = false) String signature,
                                 @RequestParam(value = "timestamp", required = false) String timestamp,
                                 @RequestParam(value = "nonce", required = false) String nonce,
                                 @RequestParam(value = "echostr", required = true) String echoStr) {
        //signature 微信加密签名
        //timestamp 时间戳
        //nonce 随机数
        //echostr 随机字符串
        return echoStr;
    }

    public void genMenu() {

    }

    @RequestMapping(value = "/updateWxAccessToken")
    public void updateWxAccessToken() {
        this.weChatService.updateAccessToken();
    }
}
