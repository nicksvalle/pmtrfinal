package br.com.william.nicolas.pmtrfinal.modules.categoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import br.com.william.nicolas.pmtrfinal.modules.categoria.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UpdateCategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity execute(@PathVariable Long id, CategoriaEntity categoriaEntity){
        var updateCategoria = this.categoriaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Categoria não encontrada")
        );

        updateCategoria.setDescricao(categoriaEntity.getDescricao());
        updateCategoria.setNomeCategoria(categoriaEntity.getNomeCategoria());

        return this.categoriaRepository.save(updateCategoria);
    }
}
