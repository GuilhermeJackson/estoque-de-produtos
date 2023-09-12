package com.teste.netflix.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.netflix.services.ProdutoService;
import com.teste.netflix.shared.ProdutoDTO;
import com.teste.netflix.view.model.ProdutoRequest;
import com.teste.netflix.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos() {
        List<ProdutoDTO> produtosDTO = service.obterTodos();
        ModelMapper mapper = new ModelMapper();
        List<ProdutoResponse> response = produtosDTO.stream()
                .map((produtoDTO) -> mapper.map(produtoDTO, ProdutoResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id) {
        try {
            Optional<ProdutoDTO> produto = service.obterPorId(id);
            ProdutoResponse response = new ModelMapper().map(produto.get(), ProdutoResponse.class);
            return new ResponseEntity<>(Optional.of(response), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDTO = new ModelMapper().map(produtoRequest, ProdutoDTO.class);
        produtoDTO = service.adicionar(produtoDTO);
        ProdutoResponse response = new ModelMapper().map(produtoDTO, ProdutoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(
            @PathVariable Integer id,
            @RequestBody ProdutoRequest produtoRequest) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDTO = mapper.map(produtoRequest, ProdutoDTO.class);
        produtoDTO = service.atualizar(id, produtoDTO);
        ProdutoResponse response = mapper.map(produtoDTO, ProdutoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
