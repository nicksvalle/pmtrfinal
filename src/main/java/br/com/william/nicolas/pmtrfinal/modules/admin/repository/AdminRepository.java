package br.com.william.nicolas.pmtrfinal.modules.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.william.nicolas.pmtrfinal.modules.admin.entity.AdminEntity;
import java.util.Optional;


public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
    Optional<AdminEntity> findByNomeAdmin(String nomeAdmin);
}
