package br.com.java.sistemacontrolecarros.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_veiculo")
public class Veiculo {

    @Id
    @Column(name = "idVeiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;

    @Column(name = "placa")
    @NotEmpty(message = "*Por favor forneça uma placa")
    private String placa;

    @Column(name = "modelo")
    @NotEmpty(message = "*Por favor forneça um modelo")
    private String modelo;

    @Column(name = "tipoVeiculo")
	private String tipoVeiculo;

    // @OneToOne(fetch = FetchType.LAZY,
    //         cascade =  CascadeType.ALL,
    //         mappedBy = "veiculo")
    // @OneToOne
	// @JoinColumn(name = "id")
    // private Movimentacao movimentacao;
}
