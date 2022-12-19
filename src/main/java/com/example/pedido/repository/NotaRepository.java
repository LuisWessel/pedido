package com.example.pedido.repository;

import com.example.pedido.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA Repository possui vários métodos prontas para fazer persistência no Banco de Dados.
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
