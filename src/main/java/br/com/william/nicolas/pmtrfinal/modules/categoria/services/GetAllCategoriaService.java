package br.com.william.nicolas.pmtrfinal.modules.categoria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import br.com.william.nicolas.pmtrfinal.modules.categoria.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAllCategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaEntity> execute() {
        var categoria = this.categoriaRepository.findAll();
        if (categoria.isEmpty()) {
            throw new EntityNotFoundException("Categoria não encontrada");
        } 
        
        return categoria;
    }
    
}
