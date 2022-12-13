package com.example.pedido.repository;

import com.example.pedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNome(Cliente nome);
}