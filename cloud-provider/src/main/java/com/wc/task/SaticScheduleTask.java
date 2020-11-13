package com.wc.task;

import com.wc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class SaticScheduleTask {
    @Autowired
    private TestService testService;

    @Scheduled(cron = "0/1 * * * * ?  ")
    private void taskOne() {
        final String s = testService.testOne();
        System.out.println(s);
    }


}
