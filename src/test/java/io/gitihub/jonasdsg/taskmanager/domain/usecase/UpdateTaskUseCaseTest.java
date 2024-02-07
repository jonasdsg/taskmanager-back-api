package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.exceptions.NotFoundException;
import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
        final var foundedTask = new Task(uuid, "teste", "descrição", null, null, null, null);
        final var updateTask = new Task(uuid, "founded task", "founded task description", null, null, null, null);
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
        final var updateTask = new Task(uuid, "founded task", "founded task description", null, null, null, null);
        //When
        when(taskRepository.update(updateTask)).thenReturn(updateTask);
        when(taskRepository.find(uuid)).thenReturn(null);
        //Then
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> updateTaskUseCase.update(updateTask));
        Assertions.assertEquals("task not founded", exception.getMessage());
    }
}
