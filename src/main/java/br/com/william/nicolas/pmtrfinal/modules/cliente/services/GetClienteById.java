package br.com.william.nicolas.pmtrfinal.modules.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import br.com.william.nicolas.pmtrfinal.modules.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetClienteById {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity execute(@PathVariable Long id){
        return this.clienteRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cliente não encontrada")
        );
    }
}
