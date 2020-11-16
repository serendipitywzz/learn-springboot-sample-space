package ink.openmind.springbootsamplerabbitmqproject;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/13 21:53
 * DESC 生产者
 */
@Component
public class Provider {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String msg){
        System.out.println("提供者发送消息： " + msg);
        amqpTemplate.convertAndSend("fanoutExchange", "", msg);
    }
}
