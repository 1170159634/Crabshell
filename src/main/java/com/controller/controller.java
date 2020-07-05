package com.controller;

import com.impl.impl;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller

public class controller
{
    @Autowired
    private impl implOne;

    @GetMapping(   value =  "/user/login")
    @ResponseBody
    public Map<String,Object> checkUser(@RequestParam("number") String number,
                                        @RequestParam("password") String password)
    {
        return   implOne.checkUser(number , password);
    }



    @PostMapping(value = "/user/room")
    @ResponseBody
    public Map<String,Object>   getRoom( @RequestBody user userOne)
    {
        return implOne.giveBelongRoom(userOne);
    }

    @GetMapping(value ="/user/message" )
    @ResponseBody
    public Map<String,Object> userMessage(@RequestParam("userNumber") String userNumber)
    {
        return implOne.giveOneMessage(userNumber);
    }








}
