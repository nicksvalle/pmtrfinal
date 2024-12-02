package br.com.william.nicolas.pmtrfinal.modules.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public void execute(@PathVariable Long id){
        if(this.clienteRepository.existsById(id)){
            this.clienteRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cliente não encontrada");
        }
    }
}
