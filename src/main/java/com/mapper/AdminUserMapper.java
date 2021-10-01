package com.mapper;

import com.model.AdminUser;

public interface AdminUserMapper {
    /**
    * deleteByPrimaryKey
    * @param id id
    * @return int int
    */
    int deleteByPrimaryKey(Integer id);

    /**
    * insert
    * @param record record
    * @return int int
    */
    int insert(AdminUser record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(AdminUser record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return AdminUser AdminUser
    */
    AdminUser selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(AdminUser record);
}