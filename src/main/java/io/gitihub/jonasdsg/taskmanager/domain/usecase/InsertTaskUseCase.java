package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import io.gitihub.jonasdsg.taskmanager.domain.valueobjects.SavedTaskStatus;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class InsertTaskUseCase {
    private final TaskRepository taskRepository;

    public SavedTaskStatus save(final Task task) {
        return Optional.ofNullable(taskRepository.find(task.id()))
                .map(founded -> this.mapper(founded, "not changed"))
                .orElseGet(() -> this.mapper(this.taskRepository.save(task), "saved successfully"));
    }

    private SavedTaskStatus mapper(final Task task, final String status) {
        return new SavedTaskStatus(task.id(), status);
    }
}
