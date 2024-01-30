package io.gitihub.jonasdsg.taskmanager.application.mappers;

import io.gitihub.jonasdsg.taskmanager.application.dto.SaveTaskDto;
import io.gitihub.jonasdsg.taskmanager.application.dto.SavedTaskStatusDto;
import io.gitihub.jonasdsg.taskmanager.domain.model.Category;
import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.valueobjects.SavedTaskStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TaskMapper {
    public static Task toDomain(SaveTaskDto saveTaskDto) {
        return new Task(
                null,
                saveTaskDto.title(),
                saveTaskDto.description(),
                PriorityMapper.from(saveTaskDto.priority()),
                LocalDateTime.parse(saveTaskDto.dueDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                null,
                new Category(null, saveTaskDto.category(), null));
    }

    public static SavedTaskStatusDto toDto(SavedTaskStatus save) {
        return new SavedTaskStatusDto(save.id(), save.status());
    }
}
