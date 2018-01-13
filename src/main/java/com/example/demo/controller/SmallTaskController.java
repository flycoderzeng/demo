package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/smalltask")
public class SmallTaskController {
    @Autowired
    private WeChatService weChatService;
    /**
     * 发送小任务消息
     */
    @RequestMapping(value = "/sendSmallTaskMessage", produces = {"application/json;charset=UTF-8"})
    public BaseResponse sendSmallTaskMessage() {
        String accessToken = this.weChatService.getAccessToken();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult("0");
        baseResponse.setMsg("success");

        return baseResponse;
    }
}
