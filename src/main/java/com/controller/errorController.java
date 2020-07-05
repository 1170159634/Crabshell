package com.controller;



import com.impl.ErrorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class errorController
{

    @Autowired
    private ErrorImpl error;

    //查询所有异常信息
    @RequestMapping("/getAllError")
    public Map<String,Object> getAllError()
    {
        return error.getAllSafe();
    }
    //查询该宿舍是否有异常信息
    @RequestMapping("/getOneRoomError")
    public Map<String,Object> getOneError(@RequestParam("room") String room)
    {
        return error.getOneRoomError(room);
    }
    //查询所有宿舍总共产生了多少问题
    @RequestMapping("/getUnsafeCount")
    public Map<String,Object> getUnsafeCount()
    {
        return error.getUnsafeCount();
    }
}
