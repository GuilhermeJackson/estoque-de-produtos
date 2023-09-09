package com.teste.netflix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.netflix.model.Produto;
import com.teste.netflix.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired // inversão de dependencia
    private ProdutoRepository repository;

    public List<Produto> obterTodos() {
        return repository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return repository.findById(id);
    }

    public Produto adicionar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

        public Produto atualizar(Integer id, Produto produto) {
        produto.setId(id);

        return repository.save(produto);
    }
}
