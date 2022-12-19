package com.example.pedido.repository;

import com.example.pedido.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA Repository possui vários métodos prontas para fazer persistência no Banco de Dados.
public interface ItemRepository extends JpaRepository<Item, Long> {

}
