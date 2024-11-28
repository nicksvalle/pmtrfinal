package br.com.william.nicolas.pmtrfinal.modules.categoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.categoria.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteCategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void execute(@PathVariable Long id){
        if(this.categoriaRepository.existsById(id)){
            this.categoriaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Categoria não encontrada");
        }
    }
}
