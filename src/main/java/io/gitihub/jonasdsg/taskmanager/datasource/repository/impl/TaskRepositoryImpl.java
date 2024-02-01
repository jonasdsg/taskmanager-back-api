package io.gitihub.jonasdsg.taskmanager.datasource.repository.impl;

import io.gitihub.jonasdsg.taskmanager.datasource.repository.TaskRepositoryDataSource;
import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import io.gitihub.jonasdsg.taskmanager.domain.valueobjects.SavedTaskStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
    private final TaskRepositoryDataSource taskDatasource;

    @Override
    public SavedTaskStatus save(Task task) {
        return null;
    }

    @Override
    public Task find(String id) {
        return null;
    }
}
