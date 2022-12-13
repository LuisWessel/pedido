package com.example.pedido.controller;

import com.example.pedido.model.Item;
import com.example.pedido.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/item")
public class ItemCtrl {
    @Autowired
    private ItemRepository itemsRepository;

    @GetMapping
    public List<Item> lista(){
        List<Item> items = itemsRepository.findAll();
        return items;
    }

    @PostMapping
    public ResponseEntity<Item> cadastrar(@RequestBody Item item, UriComponentsBuilder uriBuilder){
        item = itemsRepository.save(item);
        URI uri = uriBuilder.path("/Item/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);
    }

    @PutMapping
    public Item atualizaProduto(@RequestBody Item item) {
        return itemsRepository.save(item);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaProduto(@PathVariable Long id) {
        Optional<Item> item = itemsRepository.findById(id);
        if(item.isPresent()) {
            itemsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
