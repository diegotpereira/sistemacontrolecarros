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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "placa")
    @NotEmpty(message = "*Por favor forneça uma placa")
    private String placa;

    @Column(name = "modelo")
    @NotEmpty(message = "*Por favor forneça um modelo")
    private String modelo;

    @Column(name = "tipoVeiculo")
	private String tipoVeiculo;
    
}
