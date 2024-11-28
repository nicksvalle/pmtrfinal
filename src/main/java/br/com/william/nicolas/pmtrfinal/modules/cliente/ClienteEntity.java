package br.com.william.nicolas.pmtrfinal.modules.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Data
@Builder
@EqualsAndHashCode(of = "idCliente")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotBlank
    @Column(name = "nome_cliente", length = 255)
    private String nomeCliente;

    @NotBlank
    @Email
    @Column(name = "email_cliente", length = 255)
    private String emailCliente;

    @NotBlank
    @Column(length = 100)
    private String senha;

    @Column(name = "session_id", length = 255)
    private String sessionId;
}