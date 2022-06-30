package br.com.java.sistemacontrolecarros.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_preco")
public class Preco {
    
    @Id
	@NotEmpty
	private String tipoVeiculo;

    @Column(name = "precoHora")
	private Double precoHora;
	
	
	@Column(name = "precoHoraFracao")
	private Double precoHoraFracao;
}
