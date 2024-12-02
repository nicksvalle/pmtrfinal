package br.com.william.nicolas.pmtrfinal.modules.fornecedor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorEntity {
    
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;

    @NotNull
    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

    @NotNull
    @Email
    @Column(name = "email_fornecedor")
    private String emailFornecedor;

    @NotNull
    @Column(name = "telefone_fornecedor")
    private String telefoneFornecedor;
}
