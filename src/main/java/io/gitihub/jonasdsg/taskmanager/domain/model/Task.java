package io.gitihub.jonasdsg.taskmanager.domain.model;

import java.time.LocalDateTime;

public record Task(
        String id,
        String title,
        String description,
        Priority priority,
        LocalDateTime dueDate,
        LocalDateTime creationDate,
        Category category
) {}
