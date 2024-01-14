package com.intraservice.beta.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;

@Service
public class TaskSchedulingService {

    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> jobsMap;
    private static final String DEFAULT_CRON_EXPRESSION = "0 0 3 * * ?";

    public TaskSchedulingService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
        this.jobsMap = new HashMap<>();
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(
                new TaskDefinitionRunnable(),
                new CronTrigger(DEFAULT_CRON_EXPRESSION, TimeZone.getTimeZone(TimeZone.getDefault().getID())));
        jobsMap.put(UUID.randomUUID().toString(), scheduledTask);
    }

    public void scheduleATask(String jobId, Runnable tasklet, String cronExpression) {
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(
                tasklet,
                new CronTrigger(cronExpression, TimeZone.getTimeZone(TimeZone.getDefault().getID())));
        jobsMap.forEach((key, value) -> removeScheduledTask(key));
        jobsMap.put(jobId, scheduledTask);
    }

    public void removeScheduledTask(String jobId) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(jobId);
        if(scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(jobId, null);
        }
    }
}
