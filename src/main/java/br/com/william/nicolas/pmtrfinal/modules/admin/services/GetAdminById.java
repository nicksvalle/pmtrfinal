package br.com.william.nicolas.pmtrfinal.modules.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.admin.entity.AdminEntity;
import br.com.william.nicolas.pmtrfinal.modules.admin.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAdminById {
    
    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity execute(@PathVariable Long id){
        return this.adminRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Admin não encontrada")
        );
    }
}
