package com.mapper;

import com.pojo.dorm;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface dormMapper
{
    //查询该宿舍是否有异常
    @Select("select * from dorm where dorm_belongto=#{belongto}")
    List<dorm> selectByBelongto(@Param("belonto") String  belongto);

    //过往异常信息（从大到小）
    @Select("select * from dorm order by dorm_gmtcreate desc  where dorm_belongto=#{belongto}  ")
    List<dorm> selectAllError();
   //根据dorm_id查
    @Select("select * from dorm where dorm_id=#{id}")
    dorm getOneDorm(@Param("id" ) int id);

    @Insert("insert into dorm (dorm_belongto,dorm_gmtcreate,dorm_messgae) values(#{dormBelongto},#{dormGmtcreate},#{dormMessgae})")
    @Options(useGeneratedKeys=true, keyProperty="dormId", keyColumn="dorm_id")
    int   insertDorm(dorm dormOne);



}
