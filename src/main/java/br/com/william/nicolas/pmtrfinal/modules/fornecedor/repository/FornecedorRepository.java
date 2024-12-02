package br.com.william.nicolas.pmtrfinal.modules.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity.FornecedorEntity;
import java.util.Optional;


public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long>{
    Optional<FornecedorEntity> findByNomeFornecedor(String nomeFornecedor);
}
