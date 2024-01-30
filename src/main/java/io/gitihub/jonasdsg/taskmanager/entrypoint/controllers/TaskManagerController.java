package io.gitihub.jonasdsg.taskmanager.entrypoint.controllers;

import io.gitihub.jonasdsg.taskmanager.application.dto.SaveTaskDto;
import io.gitihub.jonasdsg.taskmanager.application.dto.SavedTaskStatusDto;
import io.gitihub.jonasdsg.taskmanager.application.facade.TaskFacade;
import io.gitihub.jonasdsg.taskmanager.entrypoint.constants.EntryPoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(EntryPoint.TASK_MANAGER_CONTROLLER)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TaskManagerController {
    private final TaskFacade facade;

    @PostMapping
    ResponseEntity<SavedTaskStatusDto> post(@RequestBody SaveTaskDto saveTask, UriComponentsBuilder builder) {
        final var returned = facade.save(saveTask);
        final var path = builder.path(EntryPoint.TASK_MANAGER_CONTROLLER).path(":id").buildAndExpand(returned.id());
        return ResponseEntity.created(path.toUri()).body(returned);
    }
}
