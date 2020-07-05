package com.mapper;

import com.pojo.room;
import com.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface mapperOne
{
    //用户检测登录检测
    @Select("select * from user where  user_password =#{userPassword} and user_number=#{userNumber}")
    user selectByNumber(@Param("userNumber") String userNumber,@Param("userPassword") String userPassword);


    //查询某个用户
    @Select("select * from user where user_number=#{number}")
    user selectByPrimaryKey(@Param("number")int  number );
    @Select("select user_numberm,user_name,user_power,user_belongto,user_avatarurl,user_telephone from user where user_number=#{number}")
    user selectByPrimaryKeyTwo(@Param("number")int  number );
    //查询舍友 除了自己
    @Select("select user_number,user_name,user_power,user_telephone,user_avatarurl,user_belongto from user where user_belongto=#{userBelongto} and user_number not in (#{id})")
  List<user> getFreinds(@Param("userBelongto") int userBelongto, @Param("id") int id);

   //查询舍长
    @Select("select * from user where user_belongto =#{belongto} and user_power=3")
       user  getShezhang(@Param("belongto") String belongto);

    @Select("select * from room where room_belongto=#{to}")
    room getroomHA(@Param("to") String to);

    //查询某个宿舍的所有人
    @Select("select * from user where user_belongto=#{userBelongto}")
    List<user> getAllusers(@Param("userBelongto") int userBelongto);
       //管理员查找所有房间数
    @Select("select * from room ")
    List<room> selectAllRoom();
    @Select("select * from room  where room_belongto=#{roomBelongto}")
   room  selectRoom(@Param("roomBelongto")int roomBelongto );
     //普通用户查找房间数
    @Select("select * from room where room_belongto=#{roomBelongto} ")
    room selectOneRoom(@Param("roomBelongto") int roomBelongto);

    //获取所有用户
     @Select("select user_number from user where  user_number not in (#{id})")
    List<Integer> getNumberList(@Param("id")   int id );





}
