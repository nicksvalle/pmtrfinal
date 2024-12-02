package br.com.william.nicolas.pmtrfinal.modules.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.william.nicolas.pmtrfinal.exceptions.ExistsException;
import br.com.william.nicolas.pmtrfinal.modules.admin.entity.AdminEntity;
import br.com.william.nicolas.pmtrfinal.modules.admin.repository.AdminRepository;

@Service
public class CreateAdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity execute(AdminEntity adminEntity){
        this.adminRepository.findByNomeAdmin(adminEntity.getNomeAdmin())
                                                    .ifPresent(user -> {
                                                        throw new ExistsException();
                                                    });
        
        return this.adminRepository.save(adminEntity);
    }
}
