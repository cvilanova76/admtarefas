package br.com.ccvn.admtarefas.model.enums;

import lombok.Getter;
import lombok.Setter;

public enum TaskStatus {

    PENDING("Pendente"),
    INPROGRESS("Em progresso"),
    CONCLUDED("Concluída");

    @Getter
    @Setter
    private String description;

    TaskStatus(String description){
        this.description = description;
    }

}
