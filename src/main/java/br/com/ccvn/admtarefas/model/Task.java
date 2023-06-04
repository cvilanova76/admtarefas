package br.com.ccvn.admtarefas.model;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
// serialização para encapsular os dados numa série, otimizando o processo
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Instant createdAt;

    private boolean isComplete;

    private String endDate;

    @Override
    public String toString() {
        return String.format(
                "TodoItem{id=%d, title='%s', description='%s', createdAt='%s', isComplete='%s', endDate='%s'}",
                id, title, description, createdAt, isComplete, endDate);
    }
}
