package br.com.java.sistemacontrolecarros.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_tiket")
public class Tiket {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "VeiculoPlaca")
    private String VeiculoPlaca;

    @Column(name = "dataEntrada")
    private LocalDate dataEntrada;

	@Column(name = "dataSaida")
    private LocalDate dataSaida;

	@Column(name = "horaEntrada")
	private LocalTime horaEntrada;

	@Column(name = "horaSaida")
	private LocalTime horaSaida;

	@Column(name = "precoHora")
	private Double precoHora;

	@Column(name = "valorTotal")
	private Double valorTotal;

	@Column(length = 10)
	private String tipoVeiculo;
    
}
