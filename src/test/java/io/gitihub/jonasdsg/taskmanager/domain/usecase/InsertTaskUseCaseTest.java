package io.gitihub.jonasdsg.taskmanager.domain.usecase;

import io.gitihub.jonasdsg.taskmanager.domain.model.Task;
import io.gitihub.jonasdsg.taskmanager.domain.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InsertTaskUseCaseTest {
    private final TaskRepository taskRepository = mock(TaskRepository.class);
    private final InsertTaskUseCase insertTaskUseCase = new InsertTaskUseCase(taskRepository);

    @Test
    void saveExistentTaskAndItHadToReturnSavedStatusWithStatusNotChanged() {
        //Given
        var uuid = UUID.randomUUID().toString();
        var task = new Task(uuid, null, null, null, null, null, null);
        //When
        Mockito.when(taskRepository.find(uuid)).thenReturn(task);
        //Then
        var existent = insertTaskUseCase.save(task);
        Assertions.assertEquals("not changed", existent.status());
    }

    @Test
    void saveNewTaskAndItHadToReturnSavedStatusWithStatusSavedSuccessfullyAndTheNewTaskId() {
        //Given
        final var uuid = UUID.randomUUID().toString();
        final var task = new Task(null, null, null, null, null, null, null);
        final var saved = new Task(uuid, null, null, null, null, null, null);
        //When
        Mockito.when(taskRepository.save(task)).thenReturn(saved);
        //Then
        var existent = insertTaskUseCase.save(task);
        Assertions.assertEquals("saved successfully", existent.status());
        Assertions.assertEquals(uuid, existent.id());
    }
}
