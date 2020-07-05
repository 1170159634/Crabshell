package com.pojo;

import lombok.Data;

@Data
public class article
{

    private  int articleNumber;
    //发表作者编号
    private  int articleWriter;
    //发表的作者姓名
    private String articleName;

    //发表的文章标题
    private String articleTitle;

    //发表内容
    private String articleText;
    //发表时间
    private String  articleCreate;
    //本人头像
    private String articleAvatarurl;
    //紧急程度
    private int articleLevel;

}
