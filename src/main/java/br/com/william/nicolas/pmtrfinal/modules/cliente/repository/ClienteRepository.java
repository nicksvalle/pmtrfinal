package br.com.william.nicolas.pmtrfinal.modules.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.william.nicolas.pmtrfinal.modules.cliente.entity.ClienteEntity;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
    Optional<ClienteEntity> findByNomeCliente(String nomeCliente);
}
