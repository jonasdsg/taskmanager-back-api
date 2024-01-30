package io.gitihub.jonasdsg.taskmanager.application.facade;

import io.gitihub.jonasdsg.taskmanager.application.dto.SaveTaskDto;
import io.gitihub.jonasdsg.taskmanager.application.dto.SavedTaskStatusDto;
import io.gitihub.jonasdsg.taskmanager.application.mappers.TaskMapper;
import io.gitihub.jonasdsg.taskmanager.domain.usecase.InsertTaskUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TaskFacade {
    private final InsertTaskUseCase insertTaskUseCase;
    public SavedTaskStatusDto save(SaveTaskDto task){
        return TaskMapper.toDto(insertTaskUseCase.save(TaskMapper.toDomain(task)));
    }
}
