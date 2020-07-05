package com.mapper;

import com.pojo.article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface articleMapper
{
    //查看所有内容(时间戳排序)
    @Select("select * from article    order by    article_create    desc ")
    List<article> selectArticleList();

    //发表一篇文章
    @Insert("insert into article (article_title,article_text,article_create,article_writer,article_avatarurl,article_name,article_level)" +
            "values (#{articleTitle},#{articleText},#{articleCreate},#{articleWriter},#{articleAvatarurl},#{articleName},#{articleLevel})")
    @Options(useGeneratedKeys=true, keyProperty="articleNumber", keyColumn="article_number")
     int insertIntoArticle(article articleOne);

    //查询某个文章
    @Select("select * from article where article_number=#{articleNumber}")
    article selectArticle(@Param("articleNumber") int article_number);



}
