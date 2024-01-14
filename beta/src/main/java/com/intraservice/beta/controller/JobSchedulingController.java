package com.intraservice.beta.controller;

import com.intraservice.beta.dto.TaskDefinition;
import com.intraservice.beta.service.TaskDefinitionRunnable;
import com.intraservice.beta.service.TaskSchedulingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
public class JobSchedulingController {

    private final TaskSchedulingService taskSchedulingService;
    private final TaskDefinitionRunnable taskDefinitionRunnable;

    @PostMapping(path="/schedule")
    public void scheduleATask(@RequestBody TaskDefinition taskDefinition) {
        taskDefinitionRunnable.setTaskDefinition(taskDefinition);
        taskSchedulingService.scheduleATask(
                UUID.randomUUID().toString(), taskDefinitionRunnable, taskDefinition.getCronExpression());
    }
}
