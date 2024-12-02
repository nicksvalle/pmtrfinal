package br.com.william.nicolas.pmtrfinal.modules.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.william.nicolas.pmtrfinal.modules.admin.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteAdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public void execute(@PathVariable Long id){
        if(this.adminRepository.existsById(id)){
            this.adminRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Admin não encontrada");
        }
    }
}
