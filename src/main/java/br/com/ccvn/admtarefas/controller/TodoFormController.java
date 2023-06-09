package br.com.ccvn.admtarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ccvn.admtarefas.dto.NewTodoItemDto;
import br.com.ccvn.admtarefas.model.entities.TodoItem;
import br.com.ccvn.admtarefas.service.TodoItemService;
import jakarta.validation.Valid;
import lombok.Getter;

@Controller
public class TodoFormController {

    @Autowired
    @Getter
    private TodoItemService todoItemService;

    // carrega formulário
    @GetMapping("/create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "new-todo-item";
    }

    @GetMapping("/view-todo")
    public String findAll(Model model) {
        model.addAttribute("todoItems", todoItemService.findAll());
        return "view-todo";
    }

    // salva
    @PostMapping("/todo")
    public String createTodoItem(@ModelAttribute("todoItem") @Valid NewTodoItemDto todoItem) {
        getTodoItemService().save(todoItem);
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

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        todoItemService.deleteById(id);
        return "redirect:/";
    }

}
