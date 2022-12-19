package com.example.pedido.repository;

import com.example.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA Repository possui vários métodos prontas para fazer persistência no Banco de Dados.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByDescricao(Produto descricao);
}
