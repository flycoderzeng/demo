package com.example.demo.mapper;

import java.util.List;
import com.example.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //自己加的
    List<User> selectAllUser();

    User findByUserName(String userName);
}