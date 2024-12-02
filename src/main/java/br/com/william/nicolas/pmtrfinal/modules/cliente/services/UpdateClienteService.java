package br.com.william.nicolas.pmtrfinal.modules.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import br.com.william.nicolas.pmtrfinal.modules.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UpdateClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity execute(@PathVariable Long id, ClienteEntity clienteEntity){
        var updateCliente = this.clienteRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cliente não encontrada")
        );

        updateCliente.setEmailCliente(clienteEntity.getEmailCliente());
        updateCliente.setSenhaCliente(clienteEntity.getSenhaCliente());
        updateCliente.setNomeCliente(clienteEntity.getNomeCliente());

        return this.clienteRepository.save(updateCliente);
    }
}
