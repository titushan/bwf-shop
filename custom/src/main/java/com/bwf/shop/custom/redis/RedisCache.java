package com.bwf.shop.custom.redis;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
public class RedisCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id; // 缓存实例id
    private RedisTemplate redisTemplate;
    private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间
    public RedisCache() {
        this.id = UUID.randomUUID().toString();
    }
    /**
     * 构造器
     * @param id 缓存Id
     * */
    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存实例需要Id");
        }
        this.id = id;
    }

    /**
     * 将key和value添加到redis缓存
     * @param key 缓存记录的key
     * @param value 缓存记录的value
     */
    @Override
    @SuppressWarnings("unchecked")
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        System.out.println(" **** ==> 向redis缓存中添加数据，key = "+ key + " , value = " + value );
    }
    /**
     * 从redis缓存中获取指定key的value
     * @param key 要获取redis缓存数据的key
     * @return redis缓存中key对应的value
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        Object value = opsForValue.get(key);
        System.out.println(" **** ==> 从redis缓存中获取数据，key = "+ key + " , value = " + value );
        return value;
    }
    /**
     * 从redis缓存中移除指定key的value
     * @param key 要移除redis缓存数据的key
     * @return null
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(key);
        System.out.println(" **** ==> 从redis缓存中移除数据，key = "+ key  );
        return null;
    }
    /**
     * 清空redis缓存数据
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public int getSize() {
        return 0;
    }
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }
}
