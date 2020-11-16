package ink.openmind.springbootsampletimedtaskproject.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 21:57
 * DESC
 */
@Service
public class NotifyService {

    public void sendMessageToUser(){
        System.out.println(new Date() + "通知方法被定时任务调用，开始发送通知！");
        // to do something
        // 可以在该方法里写入逻辑代码，定时任务会定时调用该方法
    }
}
