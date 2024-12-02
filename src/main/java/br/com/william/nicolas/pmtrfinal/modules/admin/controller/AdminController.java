package br.com.william.nicolas.pmtrfinal.modules.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.nicolas.pmtrfinal.modules.admin.entity.AdminEntity;
import br.com.william.nicolas.pmtrfinal.modules.admin.services.CreateAdminService;
import br.com.william.nicolas.pmtrfinal.modules.admin.services.DeleteAdminService;
import br.com.william.nicolas.pmtrfinal.modules.admin.services.GetAllAdminService;
import br.com.william.nicolas.pmtrfinal.modules.admin.services.GetAdminById;
import br.com.william.nicolas.pmtrfinal.modules.admin.services.UpdateAdminService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CreateAdminService createAdminService;

    @Autowired
    private GetAllAdminService getAllAdminService;

    @Autowired
    private GetAdminById getAdminById;

    @Autowired
    private UpdateAdminService updateAdminService;

    @Autowired
    private DeleteAdminService deleteAdminService;

    @PostMapping("/")
     public ResponseEntity<Object> create(@Valid @RequestBody AdminEntity adminEntity) {
        try {
            var result = this.createAdminService.execute(adminEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            var allAdmin = this.getAllAdminService.execute();
            return ResponseEntity.ok().body(allAdmin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable Long id) {
        try {
            var admin = this.getAdminById.execute(id);
            return ResponseEntity.ok().body(admin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdmin(@Valid @RequestBody AdminEntity adminEntity, @PathVariable Long id){
        try {
            var updateAdmin = this.updateAdminService.execute(id, adminEntity);
            return ResponseEntity.ok().body(updateAdmin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdmin(@Valid @PathVariable Long id) {
        try {
            this.deleteAdminService.execute(id);
            return ResponseEntity.ok().body("Admin Excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
