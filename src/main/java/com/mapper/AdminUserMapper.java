package com.mapper;

import com.model.AdminUser;
import com.model.AdminUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(AdminUserExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(AdminUserExample example);

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
    * selectByExample
    * @param example example
    * @return List<AdminUser> List<AdminUser>
    */
    List<AdminUser> selectByExample(AdminUserExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return AdminUser AdminUser
    */
    AdminUser selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

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