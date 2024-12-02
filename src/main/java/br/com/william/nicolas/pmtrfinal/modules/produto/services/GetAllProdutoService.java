package br.com.william.nicolas.pmtrfinal.modules.produto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.modules.produto.entity.ProdutoEntity;
import br.com.william.nicolas.pmtrfinal.modules.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAllProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> execute() {
        var produto = this.produtoRepository.findAll();
        if (produto.isEmpty()) {
            throw new EntityNotFoundException("Produto não encontrada");
        } 
        
        return produto;
    }
    
}
