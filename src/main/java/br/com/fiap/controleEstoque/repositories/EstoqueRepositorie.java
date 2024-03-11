package br.com.fiap.controleEstoque.repositories;

import br.com.fiap.controleEstoque.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepositorie extends JpaRepository<Estoque, Long> {
}
