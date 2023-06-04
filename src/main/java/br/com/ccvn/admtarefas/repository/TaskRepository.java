package br.com.ccvn.admtarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ccvn.admtarefas.model.Task;

//@repository desnecessário pois o JpaRepository já implementa
public interface TaskRepository extends JpaRepository<Task, Long>{
    

}
