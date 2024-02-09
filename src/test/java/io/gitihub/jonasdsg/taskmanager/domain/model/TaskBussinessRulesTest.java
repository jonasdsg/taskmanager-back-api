package io.gitihub.jonasdsg.taskmanager.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskBussinessRulesTest {

    @Test
    void shouldThrowAnExceptionWhenTheTaskIsCreatedWithoutId(){
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null, "test", "test", Priority.LOW, LocalDateTime.now().plusHours(24), LocalDateTime.now(), null));
        Assertions.assertEquals("The task id cannot be null!", exception.getMessage());
    }

    @Test
    void shouldThrowAnExceptionWhenTheTaskIsCreatedWithoutPriority(){
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("taskId", "test", "test", null, LocalDateTime.now().plusHours(24), LocalDateTime.now(), null));
        Assertions.assertEquals("The task must have a priority!", exception.getMessage());
    }

    @Test
    void shouldThrowAnExceptionWhenTheTaskIsCreatedWithoutDueDate(){
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("taskId", "test", "test", Priority.LOW, null, LocalDateTime.now(), null));
        Assertions.assertEquals("The task must have a due date!", exception.getMessage());
    }

    @Test
    void shouldThrowAnExceptionWhenTheTaskIsCreatedWithDueDateBeforeTheCreateDate(){
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("taskId", "test", "test", Priority.LOW, LocalDateTime.now().minusHours(24), LocalDateTime.now(), null));
        Assertions.assertEquals("The due date cannot be before the creation date!", exception.getMessage());
    }
}
