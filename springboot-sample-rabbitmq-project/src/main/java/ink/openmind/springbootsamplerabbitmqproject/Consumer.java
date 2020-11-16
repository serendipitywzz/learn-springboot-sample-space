package ink.openmind.springbootsamplerabbitmqproject;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/13 21:54
 * DESC 消费者
 */
@Component
public class Consumer {
    @RabbitListener(queues = "queueA")
    public void receiveQueueA(String msg){
        System.out.println("消费者queueA 收到消息： " + msg);
    }

    @RabbitListener(queues = "queueB")
    public void receiveQueueB(String msg){
        System.out.println("消费者 queueB 收到消息" + msg);
    }
}
