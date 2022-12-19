package com.example.pedido.repository;

import com.example.pedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA Repository possui vários métodos prontas para fazer persistência no Banco de Dados.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNome(Cliente nome);
}