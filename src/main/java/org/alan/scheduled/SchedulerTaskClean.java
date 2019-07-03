package org.alan.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: learn-more
 * @ClassName: SchedulerTaskClean
 * @description: 定时报时
 * @author: AlanMa
 * @create: 2019-04-28 18:15
 */
@Component
public class SchedulerTaskClean {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void report12CurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}