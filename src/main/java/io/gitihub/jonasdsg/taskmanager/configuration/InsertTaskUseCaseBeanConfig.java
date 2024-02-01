package io.gitihub.jonasdsg.taskmanager.configuration;

import io.gitihub.jonasdsg.taskmanager.domain.usecase.InsertTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertTaskUseCaseBeanConfig {
    @Bean
    public InsertTaskUseCase insertTaskUseCase(){
        return new InsertTaskUseCase(null);
    }
}
