package com.controller;

import com.impl.articleImpl;
import com.pojo.article;
import com.sun.xml.internal.xsom.impl.ParticleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class articleController
{

    @Autowired
    private articleImpl    articleimpl;
    @ResponseBody
    @RequestMapping("/questions")
    public Map<String,Object>   selectList()
    {

        return articleimpl.list();
    }

        @ResponseBody
        @RequestMapping("/publish")
        public Map<String,Object>   insertList(@RequestBody article articleOne)
        {

        return articleimpl.insertIntoArticle(articleOne);
    }
}
