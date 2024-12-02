package br.com.william.nicolas.pmtrfinal.modules.produto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.produto.entity.ProdutoEntity;
import br.com.william.nicolas.pmtrfinal.modules.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UpdateProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity execute(@PathVariable Long id, ProdutoEntity produtoEntity){
        var updateProduto = this.produtoRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não encontrada")
        );

        updateProduto.setDescricao(produtoEntity.getDescricao());
        updateProduto.setNomeProduto(produtoEntity.getNomeProduto());
        updateProduto.setEstoque(produtoEntity.getEstoque());
        updateProduto.setCategoria(produtoEntity.getCategoria());

        return this.produtoRepository.save(updateProduto);
    }
}
