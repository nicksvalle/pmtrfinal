package br.com.william.nicolas.pmtrfinal.modules.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import br.com.william.nicolas.pmtrfinal.modules.cliente.services.CreateClienteService;
import br.com.william.nicolas.pmtrfinal.modules.cliente.services.DeleteClienteService;
import br.com.william.nicolas.pmtrfinal.modules.cliente.services.GetAllClienteService;
import br.com.william.nicolas.pmtrfinal.modules.cliente.services.GetClienteById;
import br.com.william.nicolas.pmtrfinal.modules.cliente.services.UpdateClienteService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private CreateClienteService createClienteService;

    @Autowired
    private GetAllClienteService getAllClienteService;

    @Autowired
    private GetClienteById getClienteById;

    @Autowired
    private UpdateClienteService updateClienteService;

    @Autowired
    private DeleteClienteService deleteClienteService;

    @PostMapping("/")
     public ResponseEntity<Object> create(@Valid @RequestBody ClienteEntity clienteEntity) {
        try {
            var result = this.createClienteService.execute(clienteEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            var allCliente = this.getAllClienteService.execute();
            return ResponseEntity.ok().body(allCliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@Valid @PathVariable Long id) {
        try {
            var cliente = this.getClienteById.execute(id);
            return ResponseEntity.ok().body(cliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@Valid @RequestBody ClienteEntity clienteEntity, @PathVariable Long id){
        try {
            var updateCliente = this.updateClienteService.execute(id, clienteEntity);
            return ResponseEntity.ok().body(updateCliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@Valid @PathVariable Long id) {
        try {
            this.deleteClienteService.execute(id);
            return ResponseEntity.ok().body("Cliente Excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
