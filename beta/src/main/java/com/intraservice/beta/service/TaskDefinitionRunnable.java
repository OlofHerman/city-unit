package com.intraservice.beta.service;

import com.intraservice.beta.dto.TaskDefinition;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


@Service
public class TaskDefinitionRunnable implements Runnable {

    private TaskDefinition taskDefinition;
    private final Random rand = new Random();

    @Override
    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        int randVisitors = rand.nextInt(1000) + 1;

        var result = restTemplate.exchange(
                "http://localhost:8080/alpha/units/add-visitors/" + randVisitors,
                HttpMethod.PATCH,
                null,
                String.class);
    }

    public TaskDefinition getTaskDefinition() {
        return taskDefinition;
    }

    public void setTaskDefinition(TaskDefinition taskDefinition) {
        this.taskDefinition = taskDefinition;
    }
}
