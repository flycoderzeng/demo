package com.example.demo.service.impl;

import com.example.demo.Application;
import com.example.demo.common.DateFormat;
import com.example.demo.model.WeChatOfficialAccount;
import com.example.demo.service.WeChatService;
import net.minidev.json.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import com.example.demo.mapper.WeChatOfficialAccountMapper;
import java.util.Date;

@Service(value = "weChatService")
public class WeChatServiceImpl implements WeChatService{
    private final String TokenGetUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private WeChatOfficialAccountMapper weChatOfficialAccountMapper;

    @Override
    public String getAccessToken() {
        WeChatOfficialAccount weChatOfficialAccount = this.loadWeChatOfficialAccount(1);
        //如果access token 没有过期
        if(weChatOfficialAccount.getWebExpires().getTime()/1000 - 200 > new Date().getTime()) {
            return weChatOfficialAccount.getWebAccessToken();
        }

        return this.updateAccessToken();
    }

    @Override
    public String updateAccessToken(){
        WeChatOfficialAccount weChatOfficialAccount = this.loadWeChatOfficialAccount(1);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, httpHeaders);
        StringBuilder url = new StringBuilder();
        url.append(this.TokenGetUrl);
        url.append("&appid=");
        url.append(weChatOfficialAccount.getAppId());
        url.append("&secret=");
        url.append(weChatOfficialAccount.getAppSecret());
        ResponseEntity<String> response = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, String.class);
        logger.info(response.getBody());

        try {
            Object obj = JSONValue.parseStrict(response.getBody());
            JSONObject jsonObject = (JSONObject) obj;
            String accessToken = jsonObject.getAsString("access_token");
            Integer expiresIn = (Integer) jsonObject.getAsNumber("expires_in");
            if(accessToken != null && expiresIn != null) {
                //更新数据库中的记录
                weChatOfficialAccount.setWebAccessToken(accessToken);
                long d = new Date().getTime();
                d = d/1000 + expiresIn - 200;
                Date expiresDate = DateFormat.getDateWithTimestamp(d*1000);
                weChatOfficialAccount.setWebExpires(expiresDate);//提前200s过期
                this.updateWeChatOfficialAccountSelective(weChatOfficialAccount);
            }
            return accessToken;
        } catch (ParseException pe) {
            logger.info("failed to get wx access token");
            logger.info(pe.toString());
        }

        return null;
    }

    @Override
    public WeChatOfficialAccount loadWeChatOfficialAccount(int id) {
        return this.weChatOfficialAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateWeChatOfficialAccountSelective(WeChatOfficialAccount weChatOfficialAccount) {
        this.weChatOfficialAccountMapper.updateByPrimaryKeySelective(weChatOfficialAccount);
    }
}
