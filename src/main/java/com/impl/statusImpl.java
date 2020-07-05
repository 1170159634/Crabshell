package com.impl;

import com.DTO.statusDTO;
import com.mapper.articleMapper;
import com.mapper.mapperOne;
import com.mapper.statusMapper;
import com.pojo.article;
import com.pojo.status;
import com.pojo.user;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class statusImpl
{

    @Autowired
    private statusMapper statusmapper;

@Autowired
private com.mapper.mapperOne mapperone;
@Autowired
private articleMapper artcilemapper;
    //查询是否自己有未读消息
    public Map<String,Object>   checkUnreadCount(int statusReceiver)
    {
        Map<String,Object>  map=new HashMap<>();
     if(statusReceiver==0)
   {
       map.put("ycu_error", "1");
       map.put("ycu_message", "服务器异常，无法获取通知");
       return map;
   }

   else {
      int count =statusmapper.selectUnreadCount(statusReceiver);
      if(count==0)
      {
          map.put("ycu_status", "当前没有通知");
          map.put("ycu_unReadCount", 0);
      }
      else
      {
          map.put("ycu_status", "当前有未读消息");
          map.put("ycu_unReadCount", count);
      }
   }
  return map;

    }

    //展示单个文章
    public Map<String, Object> checkUnreadCountTextTwo(int statusNotifier)
    {
        Map<String,Object>  map=new HashMap<>();
        //获取未读消息的状态
        status statusOne=statusmapper.selectOnestatus(statusNotifier);
        if(statusOne!=null)
        {
            statusDTO dto=new statusDTO();
            user userOne=mapperone.selectByPrimaryKey(statusOne.getStatusNotifier());
            article articleOne=artcilemapper.selectArticle(statusOne.getStatusArticle());
            dto.setGmt_create(articleOne.getArticleCreate());
            dto.setUserName(userOne.getUserName());
            dto.setArticle_title(articleOne.getArticleTitle());
            dto.setArticle_textpart(articleOne.getArticleText());
            dto.setUserAvatarurl(userOne.getUserAvatarurl());
            dto.setStatus_number(statusOne.getStatusNumber());
            dto.setLevel(articleOne.getArticleLevel());
            dto.setTelephone(userOne.getUserTelephone());


            if(dto!=null)
            {  map.put("ycu_error", "0");
                map.put("ycu_message", dto);

            }

        }
        else
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "问题不存在了？");
        }
        return map;
    }
    //查询未读消息的具体内容(标题栏)
    public Map<String,Object>   checkUnreadCountText(int statusReceiver)
    {
        Map<String,Object>  map=new HashMap<>();
        List<status> list=new ArrayList<>();
        //获取未读消息的状态
        list=statusmapper.selectUnreadText(statusReceiver);
        if(list==null)
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "查询有异常！");
            return map;
        }
        List<statusDTO> statusDTOS=new ArrayList<>();
        for(status statusOne:list)
        {
       statusDTO dto=new statusDTO();
       user userOne=mapperone.selectByPrimaryKey(statusOne.getStatusNotifier());
       article articleOne=artcilemapper.selectArticle(statusOne.getStatusArticle());
       dto.setGmt_create(articleOne.getArticleCreate());
       dto.setArticle_title(articleOne.getArticleTitle());
       dto.setUserName(userOne.getUserName());
       dto.setLevel(articleOne.getArticleLevel());
       dto.setArticle_textpart(articleOne.getArticleText());
       dto.setUserAvatarurl(userOne.getUserAvatarurl());
       dto.setStatus_number(statusOne.getStatusNumber());
         dto.setTelephone(userOne.getUserTelephone());

         statusDTOS.add(dto);
        }

        if(statusDTOS!=null)
        {
            map.put("ycu_error", "0");
            map.put("ycu_message", statusDTOS);
        }
  return map;
    }

    //标记未读消息为已读
    public Map<String,Object>   updateSign(int statusReceiver,int status_number)
    {
        Map<String,Object>  map=new HashMap<>();
        if(StringUtils.isNotBlank(String.valueOf(status_number)) ||
                StringUtils.isNotBlank(String.valueOf(statusReceiver)))
        {

            int condition=statusmapper.updateStatus(statusReceiver,status_number);
            if(condition==1)
            {
                map.put("ycu_error", "0");
                map.put("ycu_message","修改成功 当前状态为已读");
            }
            else
            {
                map.put("ycu_error", "1");
                map.put("ycu_message","修改失败！ 检测服务器是否有异常!");
            }
        }
        else {
            map.put("ycu_error", "1");
            map.put("ycu_message","获取信息失败！");
        }
  return map;
    }


}
