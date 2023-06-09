package br.com.ccvn.admtarefas.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ccvn.admtarefas.dto.NewTodoItemDto;
import br.com.ccvn.admtarefas.dto.TodoItemDto;
import br.com.ccvn.admtarefas.model.entities.TodoItem;
import br.com.ccvn.admtarefas.repository.TodoItemRepository;
import lombok.Getter;

@Service
public class TodoItemService {
 
    @Autowired @Getter
    private TodoItemRepository todoItemRepository;

    public TodoItemDto save(NewTodoItemDto todoItemDto){
        TodoItem todoItem = dto2TodoItemBuilder(todoItemDto);
        todoItem = getTodoItemRepository().save(todoItem);
        return todoItem2TodoItemDtoBuilder(todoItem);
    }

    public List<TodoItemListDto> findAll(){
        return todoItemList2TodoItemListDto(todoItemRepository.findAll());
        
    }

    private TodoItem dto2TodoItemBuilder(NewTodoItemDto todoItemDto){
        return TodoItem.builder()
        .title(todoItemDto.getTitle())
        .description(todoItemDto.getDescription())
        .createdAt(todoItemDto.getCreatedAt())
        .endDate(todoItemDto.getEndDate())
        .taskStatus(todoItemDto.getTaskStatus())
        .build();
    }

    private TodoItemDto todoItem2TodoItemDtoBuilder(TodoItem todoItem){
        return TodoItemDto.builder()
        .id(todoItem.getId())
        .title(todoItem.getTitle())
        .description(todoItem.getDescription())
        .createdAt(todoItem.getCreatedAt())
        .endDate(todoItem.getEndDate())
        .taskStatus(todoItem.getTaskStatus())
        .build();
    }

    private List<TodoItemListDto> todoItemList2TodoItemListDto(List<TodoItem> todoItems){
        return todoItems.stream().map(todoItem -> new TodoItemListDto( todoItem.getId(), todoItem.getTitle(), todoItem.getDescription(), todoItem.getCreatedAt(), todoItem.getEndDate(), todoItem.getTaskStatus()))
        .collect(Collectors.toList());
    }


    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id){
        return todoItemRepository.findById(id);
    }   

    

    public void deleteById(Long id){
        todoItemRepository.deleteById(id);
    }

    public void deleteById(String id) {
        Long idTodoItem = Long.parseLong(id);
        todoItemRepository.deleteById(idTodoItem);
    }

    
    
    }
