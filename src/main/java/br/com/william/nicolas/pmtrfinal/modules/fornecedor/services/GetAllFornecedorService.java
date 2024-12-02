package br.com.william.nicolas.pmtrfinal.modules.fornecedor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity.FornecedorEntity;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAllFornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorEntity> execute() {
        var fornecedor = this.fornecedorRepository.findAll();
        if (fornecedor.isEmpty()) {
            throw new EntityNotFoundException("Fornecedor não encontrada");
        } 
        
        return fornecedor;
    }
    
}
