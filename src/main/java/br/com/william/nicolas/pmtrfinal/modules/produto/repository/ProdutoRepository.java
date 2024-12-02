package br.com.william.nicolas.pmtrfinal.modules.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.william.nicolas.pmtrfinal.modules.produto.entity.ProdutoEntity;
import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{
    Optional<ProdutoEntity> findByNomeProduto(String nomeProduto);
}
