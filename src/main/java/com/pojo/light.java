package com.pojo;

import lombok.Data;

@Data
public class light
{
    private int lightNumber;
    private int lightSwitch;
    private int lightBelongto;
    //灯的亮度
    private String lightLuminance;
    //门禁状态
    private int lightMen;
    //窗帘状态
    private int lightChuanglian;

}
