package com.pojo;

import lombok.Data;

@Data
public class status
{


    private int statusNumber;
    //读取状态
    private int statusRcondition;
    //发送信息的通知者
    private int statusNotifier;
    //文章的id
    private int statusArticle ;
    //文章接收者
    private   String  statusReceiver;
    private int statusLevel;
}
