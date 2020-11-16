package ink.openmind.springbootsampletimedtaskproject.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 22:01
 * DESC
 */
@Configuration
public class QuartzTaskConfig {
    @Bean
    public JobDetail simpleJobDetail(){
        return JobBuilder.newJob(QuartzTask.class)
                .withIdentity("quartzTaskJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger simpleJobTrigger(){
        // 定义每5秒执行1次
        SimpleScheduleBuilder simpleScheduleBuilder
                = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        // 定义触发器
        return TriggerBuilder
                .newTrigger()
                .forJob(simpleJobDetail())
                .withIdentity("quartzTaskJobTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}

/**
 *  定义job的执行时间为每5秒钟执行依次，设置可以自行修改，之后在类上新增@Configuration注解
 *  将其注册到IoC容器钟，否则该类不会生效
 * */