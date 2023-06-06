package br.com.ccvn.admtarefas.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ccvn.admtarefas.model.TodoItem;
import br.com.ccvn.admtarefas.repository.TodoItemRepository;




@Service
public class TodoItemService {
 
    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id){
        return todoItemRepository.findById(id);
    }   

    // estrutura condicional para setar o horário de criação se for tarefa nova
    public TodoItem save(TodoItem todoItem){
        if (todoItem.getId() == null)
            todoItem.setCreatedAt(Instant.now());
    
        return todoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }

    }
