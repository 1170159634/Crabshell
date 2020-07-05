package com.controller;

import com.impl.statusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class statusController
{

    @Autowired
    private statusImpl statusimpl;


    //查询未读消息总数
    @ResponseBody
    @RequestMapping("/unReadCount")
    public Map<String,Object>    checkUnreadCount(@RequestParam("receiver") int statusReceiver)
    {
        return statusimpl.checkUnreadCount(statusReceiver);
    }
    //返回未读消息的具体内容（标题栏）
    @ResponseBody
    @RequestMapping("/unReadTextTitle")
    public Map<String,Object> checkUnreadCountTitle(@RequestParam ("receiver")int statusReceiver)
    {
        return statusimpl.checkUnreadCountText(statusReceiver);
    }

    //返回未读消息的具体内容（单个页面显示）
    @ResponseBody
    @RequestMapping("/unReadText")
    public Map<String,Object>    checkUnreadCountText(@RequestParam ("notifier")int statusNotifier)
    {
        return statusimpl.checkUnreadCountTextTwo(statusNotifier);
    }
    //标记消息为已读
    @ResponseBody
    @RequestMapping("/updateRead")
    public Map<String,Object>     updateSign(@RequestParam ("receiver")int statusReceiver,@RequestParam("number") int status_number)
    {
        return statusimpl.updateSign(statusReceiver,status_number);
    }
}
