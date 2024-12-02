package br.com.william.nicolas.pmtrfinal.modules.produto.entity;

import java.math.BigDecimal;

import br.com.william.nicolas.pmtrfinal.modules.categoria.entity.CategoriaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(of = "idProduto")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @NotBlank
    @Column(name = "nome_produto", length = 255)
    private String nomeProduto;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotNull
    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull
    @Column(name = "estoque")
    private Integer estoque;

    @Column(name = "codigo_barras", length = 255)
    private String codigoBarras;

    @Column(name = "qr_code", length = 255)
    private String qrCode;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;
}