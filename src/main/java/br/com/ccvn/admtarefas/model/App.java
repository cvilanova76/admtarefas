package br.com.ccvn.admtarefas.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ccvn.admtarefas.model.entities.TodoItem;
import br.com.ccvn.admtarefas.repository.TodoItemRepository;

 
/* @SpringBootApplication
public class App implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        
        TodoItem todoItem = TodoItem.builder()
            .id (null)
            .title("Criar gerenciador de tarefas")
            .description("Avaliação final do curso de Java")
            .createdAt(null)
            .endDate("09/06/2023")
            .taskStatus(null)
            .build();

        TodoItem todoItem2 = new TodoItem(null, "Testar gerenciador de tarefas", "Verificar implementação dos métodos e matar todos os bugs", null, "09/06/2023", null);

        TodoItem todoItem3 = new TodoItem(null, "Revisão gerar", "Verificar todos os endpoints, h2 etc", null, "09/06/2023", null);

        TodoItemRepository.saveAll(List.of(todoItem, todoItem2, todoItem3));
        
        ;
    }
    
} 
 */