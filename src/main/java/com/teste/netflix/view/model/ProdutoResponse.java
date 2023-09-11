package com.teste.netflix.view.model;

import lombok.Data;

@Data
public class ProdutoResponse {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private String observacao;
}
