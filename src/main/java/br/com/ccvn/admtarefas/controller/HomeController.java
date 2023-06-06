package br.com.ccvn.admtarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ccvn.admtarefas.service.TodoItemService;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;
    
    //faz com que o controller retorne tanto model como view no mesmo return value
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;

    }
}
