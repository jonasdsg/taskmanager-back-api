package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import io.gitihub.jonasdsg.taskmanager.domain.valueobjects.SavedTaskStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class InsertTaskUseCase {
    private final TaskRepository taskRepository;

    public SavedTaskStatus save(final Task task) {
        return Optional.of(taskRepository.find(task.id())).stream()
                .findFirst()
                .map(saved -> new SavedTaskStatus(saved.id()))
                .orElse(taskRepository.save(task));
    }
}
