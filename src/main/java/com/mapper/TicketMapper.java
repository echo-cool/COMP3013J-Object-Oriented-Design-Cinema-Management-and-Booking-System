package com.mapper;

import com.model.Ticket;

public interface TicketMapper {
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
    int insert(Ticket record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Ticket record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Ticket Ticket
    */
    Ticket selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Ticket record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Ticket record);
}