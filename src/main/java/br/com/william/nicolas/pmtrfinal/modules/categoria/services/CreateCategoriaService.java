package br.com.william.nicolas.pmtrfinal.modules.categoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.exceptions.ExistsException;
import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import br.com.william.nicolas.pmtrfinal.modules.categoria.repository.CategoriaRepository;

@Service
public class CreateCategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity execute(CategoriaEntity categoriaEntity){
        this.categoriaRepository.findByNomeCategoria(categoriaEntity.getNomeCategoria())
                                                    .ifPresent(user -> {
                                                        throw new ExistsException();
                                                    });
        
        return this.categoriaRepository.save(categoriaEntity);
    }
}
