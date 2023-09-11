package com.teste.netflix.shared;

import lombok.Data;

@Data
//DTO - usado para transferir dados entre controller e service
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private String observacao;
}
