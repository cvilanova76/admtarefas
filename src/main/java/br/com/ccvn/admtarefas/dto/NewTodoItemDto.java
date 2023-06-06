package br.com.ccvn.admtarefas.dto;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewTodoItemDto {

    @NotBlank(message = "Campo não pode ficar vazio")
    @Size(min = 3, max = 100, message = "Campo deve ter no mínimo 3 e no máximo 100 caracteres")
    private String title;

    @NotBlank(message = "Campo não pode ficar vazio")
    @Size(min = 3, max = 100, message = "Campo deve ter no mínimo 3 e no máximo 100 caracteres")
    private String description;

    @NotBlank(message = "Campo não pode ficar vazio")
    private String endDate;

    @NotNull(message = "Campo não pode ficar vazio")
    private TaskStatus taskStatus;

}
    
