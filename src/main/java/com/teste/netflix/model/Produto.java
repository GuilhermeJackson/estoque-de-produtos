package com.teste.netflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Double valor;
    private String observacao;
    
}
