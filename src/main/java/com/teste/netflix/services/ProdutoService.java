package com.teste.netflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.netflix.model.Produto;
import com.teste.netflix.model.exception.ResourceNotFoundException;
import com.teste.netflix.repository.ProdutoRepository;
import com.teste.netflix.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired // inversão de dependencia
    private ProdutoRepository repository;

    public List<ProdutoDTO> obterTodos() {
        List<Produto> produtos = repository.findAll();
        return produtos.stream()
                .map((item) -> new ModelMapper().map(item, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> obterPorId(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto com id: " + id + " não encontrado!");
        }
        // Convertende Optional de Produto em ProdutoDTO
        ProdutoDTO dtoConvert = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dtoConvert);
    }

    public ProdutoDTO adicionar(ProdutoDTO dto) {
        dto.setId(null);
        Produto produto = new ModelMapper().map(dto, Produto.class);
        produto = repository.save(produto);
        dto.setId(produto.getId());
        return dto;
    }

    public void deletar(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível deletar o produto! O ID do produto não existe.");
        }
        repository.deleteById(id);
    }

    public ProdutoDTO atualizar(Integer id, ProdutoDTO dto) {
        dto.setId(id);
        Produto produto = new ModelMapper().map(dto, Produto.class);
        repository.save(produto);
        return dto;
    }
}
