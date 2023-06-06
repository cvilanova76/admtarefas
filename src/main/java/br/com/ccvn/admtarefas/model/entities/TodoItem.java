package br.com.ccvn.admtarefas.model.entities;

import java.io.Serializable;
import java.time.Instant;

import br.com.ccvn.admtarefas.model.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "todo_items")
@ToString
// serialização para encapsular os dados numa série, otimizando o processo
public class TodoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Instant createdAt;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private String endDate;

    @Getter
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}