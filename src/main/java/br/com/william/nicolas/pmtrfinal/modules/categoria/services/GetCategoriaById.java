package br.com.william.nicolas.pmtrfinal.modules.categoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import br.com.william.nicolas.pmtrfinal.modules.categoria.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetCategoriaById {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity execute(@PathVariable Long id){
        return this.categoriaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Categoria não encontrada")
        );
    }
}
