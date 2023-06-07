package br.com.ccvn.admtarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ccvn.admtarefas.model.entities.TodoItem;




//@repository desnecessário pois o JpaRepository já implementa
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{         
    }
    
     //tentei implementar filtro, sem sucesso
    
    /* @Query("select s from TaskStatus s where s.taskStatus like %?1%")
    static
    List<TodoItem> findTodoItemByTaskStatus(TaskStatus taskStatus){
        return Collections.emptyList();  */


