package com.teste.netflix.view.model;

import lombok.Data;

@Data
public class ProdutoRequest {
    private String nome;
    private Integer quantidade;
    private String observacao;
}
