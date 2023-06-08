package br.com.ccvn.admtarefas.dto;

import java.time.Instant;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoItemDto {


    private Long id;

    private String title;

    private String description;

    private Instant createdAt;

    private boolean complete;

    private String endDate;

    private TaskStatus taskStatus;
    
}

