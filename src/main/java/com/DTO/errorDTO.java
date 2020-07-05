package com.DTO;

import lombok.Data;

import java.util.List;

@Data
public class errorDTO
{

    private int roomNumber;
    private String roomName;
    private String errorBelongto;
    private String shezhang;
    private String tel;
    private List<?> list;
}
