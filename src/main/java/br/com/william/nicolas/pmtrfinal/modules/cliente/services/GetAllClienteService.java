package br.com.william.nicolas.pmtrfinal.modules.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import br.com.william.nicolas.pmtrfinal.modules.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAllClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> execute() {
        var cliente = this.clienteRepository.findAll();
        if (cliente.isEmpty()) {
            throw new EntityNotFoundException("Cliente não encontrada");
        } 
        
        return cliente;
    }
    
}
