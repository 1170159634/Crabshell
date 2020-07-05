package com.DTO;

import com.pojo.room;
import lombok.Data;

import java.util.List;

@Data
public class userDTO
{


    private int userNumber;
    private String userName;
    private int userPower;
    private int userBelong;
    private room roomOne;
    private String userAvatarurl;
    private String userTelephone;
    private List<?> roommates;
}
