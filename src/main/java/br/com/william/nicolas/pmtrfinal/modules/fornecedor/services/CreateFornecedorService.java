package br.com.william.nicolas.pmtrfinal.modules.fornecedor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.exceptions.ExistsException;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity.FornecedorEntity;
import br.com.william.nicolas.pmtrfinal.modules.fornecedor.repository.FornecedorRepository;

@Service
public class CreateFornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorEntity execute(FornecedorEntity fornecedorEntity){
        this.fornecedorRepository.findByNomeFornecedor(fornecedorEntity.getNomeFornecedor())
                                                    .ifPresent(user -> {
                                                        throw new ExistsException();
                                                    });
        
        return this.fornecedorRepository.save(fornecedorEntity);
    }
}
