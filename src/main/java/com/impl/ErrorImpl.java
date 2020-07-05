package com.impl;

import com.DTO.errorDTO;
import com.mapper.dormMapper;
import com.mapper.errorMapper;
import com.mapper.mapperOne;
import com.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorImpl
{

    @Autowired
    private dormMapper  mapper;
@Autowired
private com.mapper.errorMapper errorMapper;

@Autowired
private mapperOne  mapperone;
    //查询表所有宿舍的异常信息

    //查询该宿舍是否有异常信息
    public Map<String,Object> getOneRoomError(String  belongto)
    {

        Map<String,Object> map=new HashMap<>();

        try {
            Integer integer=Integer.parseInt(belongto);

        }
catch (Exception e)
{
    map.put("ycu_error", "1");
    map.put("ycu_message", "当前无法查看！请查看传递信息");
    return map;
}
        List<dorm> dorms=new ArrayList<>();
       errorDTO dtos=new errorDTO();
        if(Integer.parseInt(belongto)>0) {
            int count = errorMapper.getRoomUnSafeCount(belongto);
            if(count==0)
            {
                map.put("ycu_errorCount", "0");
                map.put("ycu_message", "该宿舍无异常信息！");
                return map;
            }
            else
            {
             List<error>   errors=errorMapper.getRoomUnSafeText(belongto);
                if(errors!=null)
                {
                    errors.stream().forEach((errorOne)->{
                    dorm dormOne=mapper.getOneDorm(errorOne.getErrorDorm());

                    dorms.add(dormOne);
                });

                    room roomOne=mapperone.getroomHA(belongto);
                    user usrOne=mapperone.getShezhang(belongto);
                    dtos.setErrorBelongto(belongto);
                    dtos.setList(dorms);
                    dtos.setRoomName(roomOne.getRoomName());
                    dtos.setShezhang(usrOne.getUserName());
                    dtos.setTel(usrOne.getUserTelephone());
                    map.put("ycu_error", 0);
                    map.put("ycu_message", dtos);
                    return map;
                }
            }
        }
        else {
            map.put("ycu_error", "1");
            map.put("ycu_message", "当前无法查看！请查看传递参数是否传错");
        }

return map;



    }

    public Map<String,Object> getUnsafeCount()
    {
        Map<String,Object> map=new HashMap<>();
        int count=errorMapper.getUnSafeCount();
        if(count==0)
        {
            map.put("ycu_error", "0");
            map.put("ycu_unSafeCount", "0");
        }
        else {
            map.put("ycu_error", "0");
            map.put("ycu_unSafeCount", count+"");
        }
        return map;

    }




    public  Map<String,Object> getAllSafe()
    {
        Map<String,Object> map=new HashMap<>();
       List<error> errors=errorMapper.getAllerrors();

      List<dormroom> dormroomList=new ArrayList<>();
       if(errors==null)
       {
           map.put("ycu_error", "0");
           map.put("ycu_unSafeText", "所有宿舍无异常信息!");
       }
       else
           {
               errors.stream().forEach((error errorOne)->{
                   dormroom dormroomOne=new dormroom();
                   dorm dormOne=mapper.getOneDorm(errorOne.getErrorDorm());
                   room roomOne=mapperone.getroomHA(String.valueOf(errorOne.getErrorBelongto()));
                   user userOne=mapperone.getShezhang(String.valueOf(errorOne.getErrorBelongto()));
                dormroomOne.setDormBelongto(dormOne.getDormBelongto());
                   dormroomOne.setDormGmtcreate(dormOne.getDormGmtcreate());
                   dormroomOne.setDormId(dormOne.getDormId());
                   dormroomOne.setDormMessgae(dormOne.getDormMessgae());
                   dormroomOne.setRoomName(roomOne.getRoomName());
                   dormroomOne.setShezhang(userOne.getUserName());
                   dormroomOne.setUserTelephone(userOne.getUserTelephone());
                   dormroomOne.setDormBelongto(dormOne.getDormBelongto());
               dormroomList.add(dormroomOne);

               });

         int count=errorMapper.getUnSafeCount();

               map.put("ycu_error", "0");
               map.put("ycu_unSafeCount", count+"");
               map.put("ycu_errorText", dormroomList);
       }
       return map;

    }




}
