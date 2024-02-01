package io.gitihub.jonasdsg.taskmanager.datasource.repository;

import io.gitihub.jonasdsg.taskmanager.datasource.repository.model.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryDataSource extends JpaRepository<TaskData, String> {
}
