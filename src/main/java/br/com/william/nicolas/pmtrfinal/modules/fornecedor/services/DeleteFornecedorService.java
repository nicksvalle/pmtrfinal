package br.com.william.nicolas.pmtrfinal.modules.fornecedor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.fornecedor.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteFornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void execute(@PathVariable Long id){
        if(this.fornecedorRepository.existsById(id)){
            this.fornecedorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Fornecedor não encontrada");
        }
    }
}
