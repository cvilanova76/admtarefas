package br.com.ccvn.admtarefas.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ccvn.admtarefas.model.Task;
import br.com.ccvn.admtarefas.repository.TaskRepository;

@Service
public class TaskService {
 
    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> getAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> getById(Long id){
        return taskRepository.findById(id);
    }   

    // estrutura condicional para setar o horário de criação se for tarefa nova
    public Task save(Task task){
        if (task.getId() == null)
            task.setCreatedAt(Instant.now());
    
        return taskRepository.save(task);
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }

    }

