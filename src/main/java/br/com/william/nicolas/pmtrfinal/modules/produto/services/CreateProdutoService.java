package br.com.william.nicolas.pmtrfinal.modules.produto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.exceptions.ExistsException;
import br.com.william.nicolas.pmtrfinal.modules.produto.entity.ProdutoEntity;
import br.com.william.nicolas.pmtrfinal.modules.produto.repository.ProdutoRepository;

@Service
public class CreateProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity execute(ProdutoEntity produtoEntity){
        this.produtoRepository.findByNomeProduto(produtoEntity.getNomeProduto())
                                                    .ifPresent(user -> {
                                                        throw new ExistsException();
                                                    });
        
        return this.produtoRepository.save(produtoEntity);
    }
}
