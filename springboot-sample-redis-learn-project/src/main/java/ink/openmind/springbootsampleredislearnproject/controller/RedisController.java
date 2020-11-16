package ink.openmind.springbootsampleredislearnproject.controller;

import ink.openmind.springbootsampleredislearnproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 18:43
 * DESC
 */

/*
* 由于Spring Boot已经自动配置StringRedisTemplate对象
* 只需要直接注入到程序中使用
* */
@RestController
public class RedisController {

    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    // 用来处理简单字符串
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 用来处理复杂对象
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 新增记录
    @GetMapping("/addStringToRedis")
    @ResponseBody
    public Boolean addStringToRedis(String key, String value){
        logger.error("key: " + key + " , value: " + value);
        stringRedisTemplate.opsForValue().set(key, value);
        return true;
    }

    // 读取记录
    @GetMapping("/getStringFromRedis")
    @ResponseBody
    public String getStringFromRedis(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *  新增3个Controller方法
     *  addUserToRedis()   拦截 /addUserRedis请求
     *  getUserFromRedis() 拦截 /getUserFromRedis请求
     *  deleteUserFromRedis() 拦截 /deleteUserFromRedis请求
     *
     *  通过方法名称可以看出其作用分别是新增一条User对象到Redis数据库
     *  根据name读取User对象和删除User对象
     *
     * */
    @GetMapping("/addUserToRedis")
    @ResponseBody
    public Boolean addUserToRedis(Integer id, String username, String password){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        logger.error(user.toString());
        redisTemplate.opsForValue().set(username, user);
        return true;
    }

    @GetMapping("/getUserFromRedis")
    @ResponseBody
    public User getUserFromRedis(String username){
        logger.error("username: " + username);
        System.out.println("---> " + username);
        return (User)redisTemplate.opsForValue().get(username);
    }

    @GetMapping("/deleteUserFromRedis")
    @ResponseBody
    public Boolean deleteUserFromRedis(String username){
        return redisTemplate.delete(username);
    }

}
