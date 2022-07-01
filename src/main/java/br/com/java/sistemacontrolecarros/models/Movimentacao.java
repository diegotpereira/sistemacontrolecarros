package br.com.java.sistemacontrolecarros.models;

import java.time.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_movimentacao")
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_entrada")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_entrada;

    @Column(name = "hora_entrada")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_entrada;

    @Column(name = "data_saida")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_saida;

    @Column(name = "hora_saida")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_saida;

    // @OneToOne
    // @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idVeiculo")
	private Veiculo veiculo;

}
