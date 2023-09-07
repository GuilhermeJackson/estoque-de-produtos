package com.teste.netflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.netflix.model.Produto;
import com.teste.netflix.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return service.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        service.deletar(id);
        return "Produto com id:" + id + "deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }
}
