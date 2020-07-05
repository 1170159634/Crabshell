package com.impl;

import com.mapper.lightMapper;
import com.mapper.mapperOne;
import com.pojo.light;
import com.pojo.room;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class lightImpl
{

@Autowired
private lightMapper lightMapper;

@Autowired
private com.mapper.mapperOne mapperone;

    public Map<String,Object>    checkLight(int lightBelongto) {
        Map<String, Object> map = new HashMap<>();
        int check;
        if (lightBelongto <= 0) {
            map.put("ycu_error", "1");
            map.put("ycu_message", "房间号错误！");
            return map;
        }


        try {
            if (StringUtils.isNotBlank(String.valueOf(lightBelongto))) {
                light lightone = lightMapper.check_switch(lightBelongto);
                    map.put("ycu_error", "0");
                    map.put("ycu_liangdu", ""+lightone.getLightLuminance());
                    map.put("ycu_deng", ""+lightone.getLightSwitch());
                    map.put("ycu_men",""+ lightone.getLightMen());
                    map.put("ycu_chuanglian", ""+lightone.getLightChuanglian());

            }
            else{
                map.put("ycu_error", "1");
                map.put("ycu_message", "接收数据出现未知错误！");
            }

        }

    catch (Exception e)
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "未找到该房间号！");
        }
        return map;
    }


    public Map<String,Object>   updateLight(int lightBelongto, int switchOne,int liangdu,int men,int chuanglian) {

        Map<String, Object> map = new HashMap<>();
        //1.先查询状态参数是否传错了
        if (StringUtils.isNotBlank(String.valueOf(lightBelongto)) && StringUtils.isNotBlank(String.valueOf(switchOne))) {
            if (switchOne != 1 && switchOne != 0) {
                map.put("ycu_error", "1");
                map.put("ycu_message", "传递状态参数时出错了？");
                return map;
            } else {
                //2.再查询房间是否存在
                room checkRoom = lightMapper.checkRoom(lightBelongto);

                if (checkRoom != null) {
                    //3.最后查询灯是否有开，如果有 只修改老二
                    light lightone = lightMapper.check_switch(lightBelongto);
                    light lightOne = new light();
                    lightOne.setLightBelongto(lightBelongto);
                    lightOne.setLightChuanglian(chuanglian);
                    lightOne.setLightSwitch(switchOne);
                    lightOne.setLightMen(men);
                    lightOne.setLightLuminance(String.valueOf(liangdu));
                    lightMapper.update_switchAndluminance(lightOne);
                    map.put("ycu_error", "0");
                    map.put("ycu_liangdu", "Luminant lamp的亮度为" + liangdu);
                    map.put("ycu_deng", "灯的开关为" + switchOne);
                    map.put("ycu_men", "门禁的开关为" + men);
                    map.put("ycu_chuanglian", chuanglian);
                    return map;
                } else {
                    map.put("ycu_error", "1");
                    map.put("ycu_message", "修改时出现未知错误！");
                }

            }
        } else {
            map.put("ycu_error", "1");
            map.put("ycu_message", "房间不存在？");
        }
        return map;
    }

    }