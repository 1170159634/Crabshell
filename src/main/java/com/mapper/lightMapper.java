package com.mapper;

import com.pojo.light;
import com.pojo.room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface lightMapper
{
    //查询成员所在灯
    @Select("select * from light  where light_belongto=#{lightBelongto}")
    light check_switch(@Param("lightBelongto") int lightBelongto       );

    //修改 主控灯，学习灯 门禁 窗帘
    @Update("update light set light_men=#{lightMen},light_chuanglian=#{lightChuanglian}," +
            "light_luminance=#{lightLuminance},light_switch=#{lightSwitch}" +
            "  where light_belongto=#{lightBelongto} ")
    int  update_switchAndluminance(light  lightOne);
    //修改门的状态

    //查询当前房间是否存在
    @Select("select * from room  where  room_belongto=#{s} ")
    room checkRoom(@Param("s") int s);

}
