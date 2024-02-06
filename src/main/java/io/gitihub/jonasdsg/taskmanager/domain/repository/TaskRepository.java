package io.gitihub.jonasdsg.taskmanager.domain.repository;

import io.gitihub.jonasdsg.taskmanager.domain.model.Task;

public interface TaskRepository {
    Task save(final Task task);

    Task find(String id);
}
