package com.example.pedido.controller;

import com.example.pedido.model.Item;
import com.example.pedido.model.Nota;
import com.example.pedido.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nota")
public class NotasCtrl {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> lista() {
        List<Nota> notas = notaRepository.findAll();
        return notas;
    }

    @PostMapping
    public ResponseEntity<Nota> cadastrar(@RequestBody Nota nota, UriComponentsBuilder uriBuilder) {
        for (Item item : nota.getItens()) {
            item.setNota(nota);
        }
        nota = notaRepository.save(nota);
        URI uri = uriBuilder.path("/Notas/{id}").buildAndExpand(nota.getId()).toUri();
        return ResponseEntity.created(uri).body(nota);
    }

    @PutMapping
    public Nota atualizaNota(@RequestBody Nota nota) {

        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaNota(@PathVariable Long id) {
        Optional<Nota> nota = notaRepository.findById(id);
        if (nota.isPresent()) {
            notaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
