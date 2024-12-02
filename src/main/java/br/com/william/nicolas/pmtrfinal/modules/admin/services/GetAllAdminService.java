package br.com.william.nicolas.pmtrfinal.modules.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.modules.admin.entity.AdminEntity;
import br.com.william.nicolas.pmtrfinal.modules.admin.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GetAllAdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminEntity> execute() {
        var admin = this.adminRepository.findAll();
        if (admin.isEmpty()) {
            throw new EntityNotFoundException("Admin não encontrada");
        } 
        
        return admin;
    }
    
}
