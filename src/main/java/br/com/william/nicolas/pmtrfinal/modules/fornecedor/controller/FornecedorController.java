package br.com.william.nicolas.pmtrfinal.modules.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity.FornecedorEntity;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.services.CreateFornecedorService;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.services.DeleteFornecedorService;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.services.GetAllFornecedorService;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.services.GetFornecedorById;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.services.UpdateFornecedorService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private CreateFornecedorService createFornecedorService;

    @Autowired
    private GetAllFornecedorService getAllFornecedorService;

    @Autowired
    private GetFornecedorById getFornecedorById;

    @Autowired
    private UpdateFornecedorService updateFornecedorService;

    @Autowired
    private DeleteFornecedorService deleteFornecedorService;

    @PostMapping("/")
     public ResponseEntity<Object> create(@Valid @RequestBody FornecedorEntity fornecedorEntity) {
        try {
            var result = this.createFornecedorService.execute(fornecedorEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            var allFornecedor = this.getAllFornecedorService.execute();
            return ResponseEntity.ok().body(allFornecedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable Long id) {
        try {
            var fornecedor = this.getFornecedorById.execute(id);
            return ResponseEntity.ok().body(fornecedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFornecedor(@Valid @RequestBody FornecedorEntity fornecedorEntity, @PathVariable Long id){
        try {
            var updateFornecedor = this.updateFornecedorService.execute(id, fornecedorEntity);
            return ResponseEntity.ok().body(updateFornecedor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFornecedor(@Valid @PathVariable Long id) {
        try {
            this.deleteFornecedorService.execute(id);
            return ResponseEntity.ok().body("Fornecedor Excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
