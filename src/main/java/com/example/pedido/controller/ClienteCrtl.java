package com.example.pedido.controller;

import com.example.pedido.model.Cliente;
import com.example.pedido.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/cliente")
public class ClienteCrtl {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> lista(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Validated Cliente cliente, UriComponentsBuilder uriBuilder){
        cliente = clienteRepository.save(cliente);
        URI uri = uriBuilder.path("/Notas/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping
    public Cliente atualizaCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
