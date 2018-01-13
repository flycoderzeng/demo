package com.example.demo.mapper;

import com.example.demo.model.WeChatOfficialAccount;

public interface WeChatOfficialAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatOfficialAccount record);

    int insertSelective(WeChatOfficialAccount record);

    WeChatOfficialAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatOfficialAccount record);

    int updateByPrimaryKeyWithBLOBs(WeChatOfficialAccount record);

    int updateByPrimaryKey(WeChatOfficialAccount record);
}