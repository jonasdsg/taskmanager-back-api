package io.gitihub.jonasdsg.taskmanager.application.mappers;

import io.gitihub.jonasdsg.taskmanager.domain.model.Priority;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PriorityMapper {
    public static Priority from(String priority) {
        return Arrays.stream(Priority.values())
                .filter(p -> p.name().equalsIgnoreCase(priority))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
