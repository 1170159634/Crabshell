package com.mapper;

import com.pojo.status;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface statusMapper
{

    @Insert("insert into status (status_article,status_notifier,status_receiver,status_level)" +
            "values (#{statusArticle},#{statusNotifier},#{statusReceiver},#{statusLevel})")
    int insertStatus(status statusOne);

    //查询未读消息的个数
   @Select("select count(1) from status  where status_receiver=#{receiver} and status_rcondition =0")
    int selectUnreadCount(@Param("receiver")  int receiver);

   //查询未读消息的具体内容(标题栏)
    @Select("select * from status where status_receiver=#{receiver} and status_rcondition =0 ")
    List<status> selectUnreadText(@Param("receiver")  int receiver);
    //查询某个单个问题
    @Select("select * from status where status_number=#{number}")
    status selectOnestatus(@Param("number") int number);
    //修改状态为已读
    @Update("update status  set status_rcondition=1 where  status_receiver=#{status_receiver} and status_number=#{status_article}")
    int updateStatus(@Param("status_receiver") int statusReceiver, @Param("status_article") int status_number);
}
