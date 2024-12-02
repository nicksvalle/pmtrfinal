package br.com.william.nicolas.pmtrfinal.modules.produto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public void execute(@PathVariable Long id){
        if(this.produtoRepository.existsById(id)){
            this.produtoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não encontrada");
        }
    }
}
