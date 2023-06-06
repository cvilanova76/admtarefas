package br.com.ccvn.admtarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ccvn.admtarefas.model.entities.TodoItem;




//@repository desnecessário pois o JpaRepository já implementa
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    

}
