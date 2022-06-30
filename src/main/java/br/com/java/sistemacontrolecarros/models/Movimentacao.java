package br.com.java.sistemacontrolecarros.models;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(name="id")
    private Long id;

    @Column(name = "data_entrada")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_entrada;

    @Column(name = "hora_entrada")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_entrada;

    @Column(name = "data_saida")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_saida;

    @Column(name = "hora_saida")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_saida;

    @OneToOne
	private Veiculo veiculo;

}
