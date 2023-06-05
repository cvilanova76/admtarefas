package br.com.ccvn.admtarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ccvn.admtarefas.model.TodoItem;
import br.com.ccvn.admtarefas.service.TodoItemService;
import jakarta.validation.Valid;

@Controller
public class TodoFormController {
    
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }


    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){

        TodoItem item = new TodoItem();
        item.setTitle(todoItem.getTitle());
        item.setDescription(todoItem.getDescription());
        item.setComplete(todoItem.isComplete());

        todoItemService.save(todoItem);
        return "redirect:/";

    }
// o uso do optional aqui permite jogar a exceção que impede refereciar um todoitem que não existe
// simplificanod a lógica
    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService
            .getById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id da tarefa " + id + " não encontrado"));

            todoItemService.delete(todoItem);
            return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService
            .getById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id da tarefa " + id + " não encontrado"));

            model.addAttribute("todo", todoItem);
            return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model){

        TodoItem item = todoItemService
            .getById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id da tarefa " + id + " não encontrado"));

            todoItem.setComplete(todoItem.isComplete());
            todoItem.setTitle(todoItem.getTitle());
            todoItem.setDescription(todoItem.getDescription());


            todoItemService.save(item);

            return "redirect:/";

    }
            
    }
    
