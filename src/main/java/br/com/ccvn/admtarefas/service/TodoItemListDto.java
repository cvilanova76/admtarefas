package br.com.ccvn.admtarefas.service;

import java.time.Instant;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;

public class TodoItemListDto {

    public TodoItemListDto(Long id, String title, String description, Instant createdAt,
            String endDate, TaskStatus taskStatus) {
    }

}
