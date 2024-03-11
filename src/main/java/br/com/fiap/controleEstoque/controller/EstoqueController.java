package br.com.fiap.controleEstoque.controller;

import br.com.fiap.controleEstoque.model.Estoque;
import br.com.fiap.controleEstoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<Estoque>  salvarEstoque(@RequestBody Estoque estoque){
        Estoque estoqueSalvo = estoqueService.salvarEstoque(estoque);
        return ResponseEntity.ok(estoqueSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<Estoque>> listarTodosProdutosComPaginacao(
            @RequestParam(value =  "page", defaultValue = "0") int page,
            @RequestParam(value =  "size", defaultValue = "10") int size) {
        Page<Estoque> estoque = estoqueService.buscaPaginada(page,size);
        return ResponseEntity.ok(estoque);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstoque(@PathVariable Long id){
        estoqueService.deletarEstoque(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Estoque> atualizarEstoque(@RequestBody Estoque estoque){
        estoqueService.atualizarEstoque(estoque);
    }
}
