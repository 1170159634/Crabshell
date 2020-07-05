package com;

import com.impl.articleImpl;
import com.mapper.articleMapper;
import com.mapper.statusMapper;
import com.pojo.article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private RedisTemplate<Object, article> templateone;
    @Autowired
    private articleImpl article;
    @Autowired
    private articleMapper mapper;
    @Test
    public void contextLoads()
    {
        List<article> list=mapper.selectArticleList();

        System.out.println(list);

    }

}
