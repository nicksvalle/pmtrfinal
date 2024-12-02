package br.com.william.nicolas.pmtrfinal.modules.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.nicolas.pmtrfinal.modules.produto.entity.ProdutoEntity;
import br.com.william.nicolas.pmtrfinal.modules.produto.services.CreateProdutoService;
import br.com.william.nicolas.pmtrfinal.modules.produto.services.DeleteProdutoService;
import br.com.william.nicolas.pmtrfinal.modules.produto.services.GetAllProdutoService;
import br.com.william.nicolas.pmtrfinal.modules.produto.services.GetProdutoById;
import br.com.william.nicolas.pmtrfinal.modules.produto.services.UpdateProdutoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CreateProdutoService createProdutoService;

    @Autowired
    private GetAllProdutoService getAllProdutoService;

    @Autowired
    private GetProdutoById getProdutoById;

    @Autowired
    private UpdateProdutoService updateProdutoService;

    @Autowired
    private DeleteProdutoService deleteProdutoService;

    @PostMapping("/")
     public ResponseEntity<Object> create(@Valid @RequestBody ProdutoEntity produtoEntity) {
        try {
            var result = this.createProdutoService.execute(produtoEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            var allProduto = this.getAllProdutoService.execute();
            return ResponseEntity.ok().body(allProduto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable Long id) {
        try {
            var produto = this.getProdutoById.execute(id);
            return ResponseEntity.ok().body(produto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduto(@Valid @RequestBody ProdutoEntity produtoEntity, @PathVariable Long id){
        try {
            var updateProduto = this.updateProdutoService.execute(id, produtoEntity);
            return ResponseEntity.ok().body(updateProduto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@Valid @PathVariable Long id) {
        try {
            this.deleteProdutoService.execute(id);
            return ResponseEntity.ok().body("Produto Excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
