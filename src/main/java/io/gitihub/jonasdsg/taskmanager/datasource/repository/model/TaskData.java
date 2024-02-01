package io.gitihub.jonasdsg.taskmanager.datasource.repository.model;

import io.gitihub.jonasdsg.taskmanager.domain.model.Category;
import io.gitihub.jonasdsg.taskmanager.domain.model.Priority;
import jakarta.persistence.Entity;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Entity
public class TaskData {
    String id;
    String title;
    String description;
    Priority priority;
    LocalDateTime dueDate;
    LocalDateTime creationDate;
    Category category;
}
