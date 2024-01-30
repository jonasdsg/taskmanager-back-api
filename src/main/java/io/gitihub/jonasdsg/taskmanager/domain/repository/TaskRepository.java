package io.gitihub.jonasdsg.taskmanager.domain.repository;

import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.valueobjects.SavedTaskStatus;

public interface TaskRepository {
    SavedTaskStatus save(final Task task);

    Task find(String id);
}
