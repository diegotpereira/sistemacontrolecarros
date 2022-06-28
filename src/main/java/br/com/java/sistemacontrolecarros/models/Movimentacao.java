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

    @Column(name = "placa")
    @NotEmpty(message = "*Por favor forneça uma placa")
    private String placa;

    @Column(name = "modelo")
    @NotEmpty(message = "*Por favor forneça um modelo")
    private String modelo;

    @Column(name = "data_entrada")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate data_entrada;

    @Column(name = "hora_entrada")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_entrada;

    @Column(name = "data_saida")
    // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate data_saida;

    @Column(name = "hora_saida")
    @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_saida;

    // @Column(name = "data_saida")
    // @DateTimeFormat(pattern = "dd-MM-yyyy")
    // @NotEmpty(message = "*Por favor forneça uma data de saída")
    // private Date data_saida;

    // public void setData_saida(Date data_saida) {
    //     try {
    //         this.data_saida = new SimpleDateFormat("dd-MM-yyyy").parse(data_saida);
    //     } catch (ParseException e) {
    //         //TODO: handle exception
    //         e.printStackTrace();
    //     }
    // }

    // @Column(name = "tempo")
    // @NotEmpty(message = "*Por favor forneça o tempo de permanencia")
    // private String tempo;

    @Column(name = "preco_Hora")
    @NotEmpty(message = "*Por favor forneça o valor da hora")
	@JsonFormat(pattern = "#,##0.00")
	private BigDecimal preco_Hora;

    @Column(name = "valor_pago")
    @NotEmpty(message = "*Por favor forneça o valor pago")
    @JsonFormat(pattern = "#,##0.00")
    private BigDecimal valor_pago;

}
