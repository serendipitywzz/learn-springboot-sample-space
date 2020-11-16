package ink.openmind.springbootsampletimedtaskproject.task;

import ink.openmind.springbootsampletimedtaskproject.service.NotifyService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 21:59
 * DESC
 */
@Component
public class QuartzTask extends QuartzJobBean {

    @Autowired
    private NotifyService notifyService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + " QuartzTask定时任务执行");
        notifyService.sendMessageToUser();

    }
}
