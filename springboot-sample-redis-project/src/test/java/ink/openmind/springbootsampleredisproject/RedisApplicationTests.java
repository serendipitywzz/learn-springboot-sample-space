package ink.openmind.springbootsampleredisproject;

import ink.openmind.springbootsampleredisproject.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/12 21:42
 * DESC
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSampleRedisProjectApplication.class)
public class RedisApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setGetTest(){
        redisUtil.set("tool-name", "IDEA【SpringBoot集成Redis】");
        System.out.println(redisUtil.get("tool-name"));
        Assert.assertEquals("IDEA【SpringBoot集成Redis】",redisUtil.get("tool-name"));
        redisUtil.del("tool-name");
    }

    @Test
    public void delKeyTest(){
        redisUtil.set("username", "王雨婷");
        redisUtil.del("username");
        Assert.assertNull(redisUtil.get("username"));
    }

    @Test
    public void updateTest(){
        redisUtil.set("old","old");
        Assert.assertEquals(redisUtil.getSet("old", "new"), "old");
        Assert.assertEquals(redisUtil.get("old"), "new");
        redisUtil.del("old");
    }

    @Test
    public void expireTest(){
        redisUtil.set("expireTest", "expireTest");
        redisUtil.expire("expireTest", 1000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(redisUtil.ttl("expireTest", TimeUnit.MILLISECONDS) < 1000);
        redisUtil.del("expireTest");
    }

    @Test
    public void hgetAndHsetTest(){
        redisUtil.hset("shi", "yan", "lou");
        Assert.assertEquals(redisUtil.hget("shi","yan"), "lou");
        redisUtil.del("shi");
    }

}
