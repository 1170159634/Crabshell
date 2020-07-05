package com.config;


import com.pojo.article;


import com.pojo.user;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
public class MyRedisConfig
{
 @Bean
    public RedisTemplate<Object, article> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
           RedisTemplate<Object,article> template = new RedisTemplate<>();
          template.setConnectionFactory(redisConnectionFactory);
            //设置json格式的序列化器
        Jackson2JsonRedisSerializer<article> jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<article>(article.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
       return template;
    }


 @Bean
 public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
     //初始化一个RedisCacheWriter
     RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
     //设置CacheManager的值序列化方式为json序列化
     RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
     RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
             .fromSerializer(jsonSerializer);
     RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
             .serializeValuesWith(pair);
     //设置默认超过期时间是30秒
     defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
     //初始化RedisCacheManager
     return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
 }
}
