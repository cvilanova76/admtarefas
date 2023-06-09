package br.com.ccvn.admtarefas.dto;

import java.time.Instant;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoItemListDto {
    
    private Long id;

    private String title;

    private String description;

    private Instant createdAt;

    private String endDate;

    private TaskStatus taskStatus;

}