package com.example.demo.mapper;

import com.example.demo.model.AutoCaseProjectRelation;

public interface AutoCaseProjectRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoCaseProjectRelation record);

    int insertSelective(AutoCaseProjectRelation record);

    AutoCaseProjectRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoCaseProjectRelation record);

    int updateByPrimaryKey(AutoCaseProjectRelation record);
}