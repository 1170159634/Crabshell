package com.impl;

import com.DTO.userClickDTO;
import com.DTO.userDTO;
import com.mapper.mapperOne;
import com.pojo.room;
import com.pojo.user;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.expression.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@CacheConfig(cacheManager = "cacheManager")
public class impl
{

@Autowired
    private mapperOne mapper;


    @Cacheable(cacheNames = "emp",key = "#usernumber",unless = "#result==null")
    public Map<String,Object>   checkUser(String usernumber ,String password)
    {
        Map<String,Object> map=new HashMap<>();

        //当前检测字符串正常，并没有出现错误
        if(StringUtils.isNotBlank(usernumber) && StringUtils.isNotBlank(password)    )
        {

            user userOne=mapper.selectByNumber(usernumber, password);
            if(userOne!=null)
            {
            userDTO dto =new userDTO();

            dto.setUserBelong(userOne.getUserBelongto());
            dto.setUserName(userOne.getUserName());
            dto.setUserPower(userOne.getUserPower());
            dto.setUserName(userOne.getUserName());
            dto.setUserAvatarurl(userOne.getUserAvatarurl());
            dto.setUserTelephone(userOne.getUserTelephone());
         dto.setRoomOne(mapper.selectRoom(userOne.getUserBelongto()));
        dto.setRoommates( mapper.getFreinds(userOne.getUserBelongto(), userOne.getUserNumber()));




            map.put("ycu_error", "0");
            map.put("ycu_message", dto);
        }
        else
        {
            map.put("ycu_error", "1");
            map.put("ycu_message","用户名或密码错误！");
        }
        }

        else {
            map.put("ycu_error", "1");
            map.put("ycu_message","用户名或密码不能为空！");
        }
    return map;
    }

    @Cacheable(cacheNames = "emp",key = "#userOne.userBelongto",unless = "#result==null")
    public Map<String,Object>   giveBelongRoom(user userOne)
    {
        Map<String,Object> map=new HashMap<>();

        //当前检测字符串正常，并没有出现错误
        if(userOne !=null   )
        {
            int isRoot=userOne.getUserPower();
            if(isRoot==1)
            {
                //如果是管理员获取全部房间信息
                List<room> roomList=mapper.selectAllRoom();

                if(roomList !=null)
                {
                    map.put("ycu_error", "0");
                    map.put("ycu_message",roomList);

                }
                else
                {
                    map.put("ycu_error", "1");
                    map.put("ycu_message","获取房间列表失败！");
                }
            }


            else
                //是学生 只获取一个房间就可以
            {
             room roomOne=mapper.selectOneRoom(userOne.getUserBelongto());


                if(roomOne!=null)
                {
                    map.put("ycu_error", "0");
                    map.put("ycu_message",roomOne);
                }

            }
        }

        else {
            map.put("ycu_error", "1");
            map.put("ycu_message","获取当前用户信息失败！");
        }
        return map;
    }



    public Map<String, Object> giveOneMessage(String userNumber) {

        Map<String,Object> map=new HashMap<>();

        if(StringUtils.isNotBlank(userNumber))
        {
            try {
                user userOne=mapper.selectByPrimaryKey(Integer.parseInt(userNumber));
                if(userOne!=null)
                {
                 userClickDTO userClickDTO=new userClickDTO();
                 userClickDTO.setUser_avatarURL(userOne.getUserAvatarurl());
                 userClickDTO.setUser_number(userOne.getUserNumber());
                 userClickDTO.setUser_telephone(userOne.getUserTelephone());
                 userClickDTO.setUser_name(userOne.getUserName());
                 if(userOne.getUserPower()==1)
                 {
                     userClickDTO.setPower("管理员");
                 }
                 else {
                     userClickDTO.setPower("学生");
                 }
                 if(userOne.getUserBelongto()==0)
                 {  userClickDTO.setUser_room("管理全部宿舍");

                 }
                 else {
                     room roomOne=mapper.selectRoom(userOne.getUserBelongto());
                     userClickDTO.setUser_room(roomOne.getRoomName());
                 }


                 map.put("error", 0);
                 map.put("message", userClickDTO);
                    return map; }
            }catch (Exception e)
            {
                e.printStackTrace();

            }





        }
        else
        {

            map.put("error", 1);
            map.put("message", "获取失败！检查是否存在该用户");

        }
        return map;
    }
    }

