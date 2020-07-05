package com.mapper;

import com.pojo.item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface itemmapper
{
    @Select("select  * from item where item_id=1")
    item selectByPrimaryKey();
}
