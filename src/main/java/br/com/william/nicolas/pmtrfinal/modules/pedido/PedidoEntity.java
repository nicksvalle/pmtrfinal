package br.com.william.nicolas.pmtrfinal.modules.pedido;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.william.nicolas.pmtrfinal.modules.cliente.ClienteEntity;

@Data
@Builder
@EqualsAndHashCode(of = "idPedido")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    @NotNull
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;
}
