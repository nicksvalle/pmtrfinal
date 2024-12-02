package br.com.william.nicolas.pmtrfinal.modules.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.exceptions.ExistsException;
import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import br.com.william.nicolas.pmtrfinal.modules.cliente.repository.ClienteRepository;

@Service
public class CreateClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity execute(ClienteEntity clienteEntity){
        this.clienteRepository.findByNomeCliente(clienteEntity.getNomeCliente())
                                                    .ifPresent(user -> {
                                                        throw new ExistsException();
                                                    });
        
        return this.clienteRepository.save(clienteEntity);
    }
}
