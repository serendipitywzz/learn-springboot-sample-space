package ink.openmind.springbootsamplerabbitmqproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/13 21:58
 * DESC
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSampleRabbitmqProjectApplication.class)
public class RabbitApplicationTests {
    @Autowired
    private Provider provider;

    @Test
    public void providerTest(){
        provider.sendMessage("【msg】 - We are the world!");
    }
}
