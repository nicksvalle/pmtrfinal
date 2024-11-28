package br.com.william.nicolas.pmtrfinal.modules.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import java.util.Optional;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    Optional<CategoriaEntity> findByNomeCategoria(String nomeCategoria);
}
