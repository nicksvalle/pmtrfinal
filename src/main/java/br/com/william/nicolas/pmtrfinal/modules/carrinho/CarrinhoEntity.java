package br.com.william.nicolas.pmtrfinal.modules.carrinho;

import br.com.william.nicolas.pmtrfinal.modules.cliente.ClienteEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho;

    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    

}
