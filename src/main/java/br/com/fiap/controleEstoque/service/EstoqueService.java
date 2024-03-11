package br.com.fiap.controleEstoque.service;


import br.com.fiap.controleEstoque.model.Estoque;
import br.com.fiap.controleEstoque.repositories.EstoqueRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepositorie estoqueRepositorie;

    public Estoque salvarEstoque(Estoque estoque){

        return    estoqueRepositorie.save(estoque);
    }

    public Page<Estoque> buscaPaginada(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.unsorted());
       return estoqueRepositorie.findAll(pageRequest);
    }

    public void deletarEstoque(Long id) {
        estoqueRepositorie.deleteById(id);
    }

    public void atualizarEstoque(Estoque estoque) {
       Optional<Estoque> estoqueSalvo = estoqueRepositorie.findById(estoque.getId());
        estoqueRepositorie.save(estoque);
    }
//http://localhost:8080/estoque/1

}
