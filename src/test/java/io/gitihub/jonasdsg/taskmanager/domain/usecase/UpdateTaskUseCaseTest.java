package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.exceptions.NotFoundException;
import io.gitihub.jonasdsg.taskmanager.domain.model.Priority;
import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UpdateTaskUseCaseTest {
    private final TaskRepository taskRepository = mock(TaskRepository.class);
    private final UpdateTaskUseCase updateTaskUseCase = new UpdateTaskUseCase(taskRepository);

    @Test
    void testUpdateAndMustReturnTheTaskUpdated() {
        //Given
        final var uuid = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDate = now.plusHours(24);
        final var foundedTask = new Task(uuid, "teste", "descrição", Priority.LOW, dueDate, now, null);
        final var updateTask = new Task(uuid, "founded task", "founded task description", Priority.LOW, dueDate, now, null);
        //When
        when(taskRepository.update(updateTask)).thenReturn(updateTask);
        when(taskRepository.find(uuid)).thenReturn(foundedTask);
        //Then
        final var returnedTask = updateTaskUseCase.update(updateTask);
        Assertions.assertEquals(updateTask, returnedTask);
    }

    @Test
    void testUpdateAndMustThrowAndExceptionWithNotFoundTaskMessage() {
        //Given
        final var uuid = UUID.randomUUID().toString();
        final var updateTask = new Task(uuid, "founded task", "founded task description", Priority.LOW, LocalDateTime.now().plusHours(24), LocalDateTime.now(), null);
        //When
        when(taskRepository.update(updateTask)).thenReturn(updateTask);
        when(taskRepository.find(uuid)).thenReturn(null);
        //Then
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> updateTaskUseCase.update(updateTask));
        Assertions.assertEquals("task not founded", exception.getMessage());
    }
}
