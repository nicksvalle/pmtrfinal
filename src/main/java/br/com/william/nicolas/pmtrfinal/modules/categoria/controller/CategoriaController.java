package br.com.william.nicolas.pmtrfinal.modules.categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import br.com.william.nicolas.pmtrfinal.modules.categoria.services.CreateCategoriaService;
import br.com.william.nicolas.pmtrfinal.modules.categoria.services.DeleteCategoriaService;
import br.com.william.nicolas.pmtrfinal.modules.categoria.services.GetAllCategoriaService;
import br.com.william.nicolas.pmtrfinal.modules.categoria.services.GetCategoriaById;
import br.com.william.nicolas.pmtrfinal.modules.categoria.services.UpdateCategoriaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CreateCategoriaService createCategoriaService;

    @Autowired
    private GetAllCategoriaService getAllCategoriaService;

    @Autowired
    private GetCategoriaById getCategoriaById;

    @Autowired
    private UpdateCategoriaService updateCategoriaService;

    @Autowired
    private DeleteCategoriaService deleteCategoriaService;

    @PostMapping("/")
     public ResponseEntity<Object> create(@Valid @RequestBody CategoriaEntity categoriaEntity) {
        try {
            var result = this.createCategoriaService.execute(categoriaEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            var allCategoria = this.getAllCategoriaService.execute();
            return ResponseEntity.ok().body(allCategoria);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable Long id) {
        try {
            var categoria = this.getCategoriaById.execute(id);
            return ResponseEntity.ok().body(categoria);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategoria(@Valid @RequestBody CategoriaEntity categoriaEntity, @PathVariable Long id){
        try {
            var updateCategoria = this.updateCategoriaService.execute(id, categoriaEntity);
            return ResponseEntity.ok().body(updateCategoria);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoria(@Valid @PathVariable Long id) {
        try {
            this.deleteCategoriaService.execute(id);
            return ResponseEntity.ok().body("Categoria Excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
