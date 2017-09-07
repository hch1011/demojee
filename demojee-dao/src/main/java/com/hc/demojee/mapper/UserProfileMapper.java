package com.hc.demojee.mapper;

import com.hc.demojee.entity.UserProfileEntity;

public interface UserProfileMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserProfileEntity record);

    int insertSelective(UserProfileEntity record);

    UserProfileEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserProfileEntity record);

    int updateByPrimaryKey(UserProfileEntity record);
}