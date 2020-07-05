package com.impl;


import com.DTO.safeDTO;

import com.mapper.safeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class safeImpl {

    @Autowired
    private com.mapper.safeMapper safeMapper;

    public Map<String, Object> sel(Integer safeId) {

        Map<String,Object> map=new HashMap<>();
        safeDTO list= safeMapper.selectById(safeId);
        if(list==null)
        {
            map.put("ycu_message", "没有该安全知识！");
            return map;
        }else
        {
            map.put("ycu_message", list);
        }
        return map;
    }
}
