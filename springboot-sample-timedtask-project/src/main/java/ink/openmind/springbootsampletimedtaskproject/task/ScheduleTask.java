package ink.openmind.springbootsampletimedtaskproject.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 21:30
 * DESC
 */
@Component // @Component注解表示将该类注册到IoC容器钟
public class ScheduleTask {
//    /**
//     *  使用cron表达式，表示每秒钟运行1次
//     * */
//    @Scheduled(cron = "0/10 * * * * *")
//    public void scheduled1(){
//        System.out.println("schduled1定时任务执行");
//    }
//
//    /**
//     *  scheduled2()方法配置的是fixedRate属性，表示每5秒钟执行一次
//     * */
//    @Scheduled(fixedRate = 5000)
//    public void scheduled2(){
//        System.out.println(new Date() + " schduled2定时任务执行");
//    }
//
//    /**
//     * shceduled3()方法配置的是fixedDelay属性，表示每5秒钟执行依次
//     * */
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled3(){
//        System.out.println(new Date() + " scheduled3定时任务执行");
//    }

}
