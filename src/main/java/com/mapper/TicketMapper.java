package com.mapper;

import com.model.Ticket;
import com.model.TicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(TicketExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(TicketExample example);

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
    * selectByExample
    * @param example example
    * @return List<Ticket> List<Ticket>
    */
    List<Ticket> selectByExample(TicketExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Ticket Ticket
    */
    Ticket selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

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