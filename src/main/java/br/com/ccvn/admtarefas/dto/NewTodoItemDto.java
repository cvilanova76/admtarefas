package br.com.ccvn.admtarefas.dto;

import java.time.Instant;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewTodoItemDto {

    @NotBlank(message = "Campo não pode ficar vazio")
    @Size(min = 3, max = 100, message = "Campo deve ter no mínimo 3 e no máximo 100 caracteres")
    private String title;

    @NotBlank(message = "Campo não pode ficar vazio")
    @Size(min = 3, max = 100, message = "Campo deve ter no mínimo 3 e no máximo 100 caracteres")
    private String description;

    private Instant createdAt;

    private boolean complete;

    private String endDate;

    @NotNull(message = "Campo precisa ser preenchido")
    private TaskStatus taskStatus;

}
    
