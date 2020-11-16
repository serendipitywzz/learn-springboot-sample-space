package ink.openmind.springbootsampleredisproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/12 21:27
 * DESC RedisUtil工具类，用来封装redis的基本操作
 */
@Component
@SuppressWarnings("all")
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 将字符串值 value 关联到 key
     * @param key 键
     * @param value 值
     * */
    public void set(String key, String value){
        stringRedisTemplate.opsForValue()
                .set(key, value);
    }

    /**
     * 返回key所关联的字符串值
     * @param key 键
     * @param value 值
     * */
    public String get(String key){
        return stringRedisTemplate.opsForValue()
                .get(key);
    }

    /**
     * 获取键过期时间
     * @param key 键
     * @param timeUnit 时间单位
     * @param the long
     * */
    public long ttl(String key, TimeUnit timeUnit){
        return stringRedisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 设置键过期时间
     * @param key 键
     * @param timeout 过期时间
     * @param timeUnit 时间单位(unit-单位，单元)
     * @return boolean boolean
     * */
    public boolean expire(String key, long timeout, TimeUnit timeUnit){
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    /**
     * 获取旧值并且更新值
     * @param key 键
     * @param value 新值
     * @return 旧值
     * */
    public String getSet(String key, String value){
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 删除
     * @param key 键
     * @return the boolean
     * */
    public boolean del(String key){
        return stringRedisTemplate.delete(key);
    }

    /**
     * Hset 将哈希表 key中的域field的值设为value
     * @param key 键
     * @param field 域
     * @return value 值
     * */
    public void hset(String key, String field, Object value){
        stringRedisTemplate.opsForHash()
                .put(key, field, value);
    }

    /**
     * Hget 将哈希表中的value取出来
     * @param key 键
     * @return value 值
     * */
    public String hget(String key, String field){
        return (String)stringRedisTemplate.opsForHash()
                .get(key, field);
    }




}
