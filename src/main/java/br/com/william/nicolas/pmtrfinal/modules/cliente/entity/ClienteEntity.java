package br.com.william.nicolas.pmtrfinal.modules.cliente.entity;

import org.hibernate.validator.constraints.Length;

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
public class ClienteEntity {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotNull
    @Column(name = "nome_cliente")
    private String nomeCliente;

    @NotNull
    @Email
    @Column(name = "email_cliente")
    private String emailCliente;

    @NotNull
    @Length(min = 8)
    @Column(name = "senha_cliente")
    private String senhaCliente;
}
