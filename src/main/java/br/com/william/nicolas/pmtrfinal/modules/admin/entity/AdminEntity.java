package br.com.william.nicolas.pmtrfinal.modules.admin.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@EqualsAndHashCode(of = "idAdmin")
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idAdmin;

    @NotNull
    @Column(name = "nome_admin")
    private String nomeAdmin;

    @NotNull
    @Email
    @Column(name = "email_admin")
    private String emailAdmin;

    @NotNull
    @Length(min = 8)
    @Column(name = "senha_admin")
    private String senhaAdmin;
}
