package com.mapper;

import com.DTO.safeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface safeMapper {

    @Select("select * from safe where safe_id = #{safeId}")
    safeDTO selectById(@Param("safeId")int safeId);
}
