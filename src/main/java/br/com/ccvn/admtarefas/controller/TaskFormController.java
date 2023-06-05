package br.com.ccvn.admtarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ccvn.admtarefas.model.Task;
import br.com.ccvn.admtarefas.service.TaskService;
import jakarta.validation.Valid;

@Controller
public class TaskFormController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/create-task")
    public String showCreateForm(Task task){
        return "new-task";
    }


    @PostMapping("/task")
    public String createTask(@Valid Task task, BindingResult result, Model model){

        Task itemTask = new Task();
        itemTask.setTitle(task.getTitle());
        itemTask.setComplete(task.isComplete());

        taskService.save(task);
        return "redirect:/";

    }
    

}
