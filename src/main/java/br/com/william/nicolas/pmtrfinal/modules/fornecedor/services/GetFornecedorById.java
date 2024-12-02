package br.com.william.nicolas.pmtrfinal.modules.fornecedor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity.FornecedorEntity;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetFornecedorById {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorEntity execute(@PathVariable Long id){
        return this.fornecedorRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrada")
        );
    }
}
