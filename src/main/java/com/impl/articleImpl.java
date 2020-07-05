package com.impl;

import com.mapper.articleMapper;
import com.mapper.mapperOne;
import com.mapper.statusMapper;
import com.pojo.article;
import com.pojo.status;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class articleImpl
{

    @Autowired
    private articleMapper mapper;

    //获取所有学生
    @Autowired
    private mapperOne mapperone;
//    //缓存获取整个list
//    @Autowired
//    private RedisTemplate<Object, article> templateone;

    @Autowired
    private statusMapper statusmapper;
    public Map<String,Object>   list()
    {

        Map<String,Object> map=new HashMap<>();
        List<article> list=mapper.selectArticleList();

        if(list==null)
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "当前管理员没有发表过内容！");
            return map;
        }
        else
        {
            map.put("ycu_error", "0");
            map.put("ycu_message", list);
            map.put("ycu_count", list.size());
        }
        return map;
    }

    public Map<String,Object>   insertIntoArticle(article articleOne)
    {

        Map<String,Object> map=new HashMap<>();
        if(articleOne==null)
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "发表内容时出现异常！");
            return map;
        }
        if(StringUtils.isNotBlank(articleOne.getArticleText()))
        {



    //普通消息发送
        int a=     mapper.insertIntoArticle(articleOne);

        //判断是否是紧急消息
        if(articleOne.getArticleLevel()==1)
        {
            //如果是紧急消息  （获取所有user表里的id）
             List<Integer> list=mapperone.getNumberList(articleOne.getArticleWriter());
          for(Integer integer: list)
          {
              status statusOne=new status();
              statusOne.setStatusArticle(articleOne.getArticleNumber());
              statusOne.setStatusReceiver(String.valueOf(integer));
              statusOne.setStatusNotifier(articleOne.getArticleWriter());
                   statusOne.setStatusLevel(1);
              statusmapper.insertStatus(statusOne);
          }
        }
        else if(articleOne.getArticleLevel()==0)
        {
            //如果是紧急消息  （获取所有user表里的id）
            List<Integer> list=mapperone.getNumberList(articleOne.getArticleWriter());
            for(Integer integer: list)
            {
                status statusOne=new status();
                statusOne.setStatusLevel(0);
                statusOne.setStatusArticle(articleOne.getArticleNumber());
                statusOne.setStatusReceiver(String.valueOf(integer));
                statusOne.setStatusNotifier(articleOne.getArticleWriter());

                statusmapper.insertStatus(statusOne);
            }
        }

        if(a==1)
        {
            map.put("ycu_status", "success");
            map.put("ycu_message", "发表成功！");
        }
        if(a==0)
        {
            map.put("ycu_status", "failed");
            map.put("ycu_message", "发表失败！服务器可能出现崩溃了");
        }
        }
        else
        {
            map.put("ycu_error", "1");
            map.put("ycu_message", "不能输出空内容！");
        }
        return map;

    }
}
