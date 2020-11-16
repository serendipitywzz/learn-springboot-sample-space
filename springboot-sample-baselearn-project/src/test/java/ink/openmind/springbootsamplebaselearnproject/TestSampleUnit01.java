package ink.openmind.springbootsamplebaselearnproject;

import ink.openmind.springbootsamplebaselearnproject.service.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 9:30
 * DESC
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSampleUnit01 {

    // 注入HelloSerivce
    @Autowired
    private IHelloService helloService;

    @Test
    public void test(){
        // sayHello方法测试
        System.out.println(helloService.sayHello("We are the world!!!"));
    }
}
