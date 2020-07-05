package com.DTO;

import lombok.Data;

@Data
public class statusDTO
{

//未读消息框-用户头像
    private String   userAvatarurl;
    //未读消息框-用户名称
    private String userName;
   // 未读消息框-用户正文（一部分）
    private String article_textpart;
//未读消息框-用户编写的创建时间
    private String gmt_create;
    ////未读消息框-状态的编号
    private int status_number;
    //未读消息框-标题
    private String article_title;
    //未读消息框-等级
    private int Level;
    //用户电话
    private String telephone;
}
