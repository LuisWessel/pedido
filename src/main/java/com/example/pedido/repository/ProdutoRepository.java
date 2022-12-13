package com.example.pedido.repository;

import com.example.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByDescricao(Produto descricao);
}
