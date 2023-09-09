package com.teste.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.netflix.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
