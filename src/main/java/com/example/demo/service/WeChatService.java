package com.example.demo.service;

import com.example.demo.model.WeChatOfficialAccount;

public interface WeChatService {
    String getAccessToken();
    String updateAccessToken();

    WeChatOfficialAccount loadWeChatOfficialAccount(int id);

    void updateWeChatOfficialAccountSelective(WeChatOfficialAccount weChatOfficialAccount);
}
