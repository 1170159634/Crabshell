package com.controller;

import com.impl.itemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class itemController
{
    @Autowired
    private itemImpl itemimpl;

    @RequestMapping("/room/status")
    @ResponseBody
    public Map<String,Object> getStatus()
    {
        return   itemimpl.getStatus();
    }



}
