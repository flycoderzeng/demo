package com.example.demo.mapper;

import com.example.demo.model.UserProjectRelation;

public interface UserProjectRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserProjectRelation record);

    int insertSelective(UserProjectRelation record);

    UserProjectRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserProjectRelation record);

    int updateByPrimaryKey(UserProjectRelation record);
}