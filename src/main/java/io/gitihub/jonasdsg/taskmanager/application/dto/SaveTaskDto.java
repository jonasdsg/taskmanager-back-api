package io.gitihub.jonasdsg.taskmanager.application.dto;

public record SaveTaskDto(
        String title,
        String description,
        String priority,
        String dueDate,
        String category) {
}
