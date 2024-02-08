package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.exceptions.NotFoundException;
import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateTaskUseCase {
    private final TaskRepository taskRepository;

    public Task update(Task task) {
        return Optional.ofNullable(taskRepository.find(task.id()))
                .map(foundedTask -> updateFoundedTask(foundedTask, task))
                .orElseThrow(() -> new NotFoundException("task not founded"));
    }

    private Task updateFoundedTask(Task foundedTask, Task task) {
        return taskRepository.update(foundedTask.update(task));
    }
}
