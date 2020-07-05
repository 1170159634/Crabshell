package com.mapper;

import com.pojo.error;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface errorMapper
{
    //查询当前发生过的异常
     @Select("select * from error")
    List<error> getAllerrors();

     //查询当前宿舍发生安全异常状态
     @Select("select * from error where error_belongto=#{belongto}")
    List<error> getRoomUnSafeText(String  belongto);

   @Insert("insert into error (error_belongto,error_dorm) values(#{errorBelongto},#{errorDorm})")
   void insertError(error errorOne);
    //查询当前宿舍发生安全状况几次
    @Select("select count(1) from error where error_belongto=#{belongto}")
    int getRoomUnSafeCount(String  belongto);

    //查询总共发生过多少异常
   @Select("select count(1) from error")
    int getUnSafeCount();

}
