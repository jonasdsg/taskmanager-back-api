package io.gitihub.jonasdsg.taskmanager.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public record Task(
        String id,
        String title,
        String description,
        Priority priority,
        LocalDateTime dueDate,
        LocalDateTime creationDate,
        Category category
) {
    public Task {
        if (Objects.isNull(id) || id.trim().isBlank()) {
            throw new IllegalArgumentException("The task id cannot be null!");
        }
        if (Objects.isNull(priority)) {
            throw new IllegalArgumentException("The task must have a priority!");
        }
        if (Objects.isNull(dueDate)) {
            throw new IllegalArgumentException("The task must have a due date!");
        }
        if(dueDate.isBefore(creationDate)){
            throw new IllegalArgumentException("The due date cannot be before the creation date!");
        }
    }

    public Task update(Task task) {
        return new Task(
                this.id(),
                task.title(),
                task.description(),
                task.priority(),
                task.dueDate(),
                this.creationDate(),
                task.category()
        );
    }
}
