package com.example.pedido.controller;

import com.example.pedido.model.Produto;
import com.example.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoCtrl {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> lista(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        produto = produtoRepository.save(produto);
        URI uri = uriBuilder.path("/Notas/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
