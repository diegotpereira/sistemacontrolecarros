package br.com.java.sistemacontrolecarros.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

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
    @NotEmpty(message = "*Por favor forneça uma data de entrada")
    private LocalDateTime data_entrada = LocalDateTime.now();

    @Column(name = "data_saida")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotEmpty(message = "*Por favor forneça uma data de saída")
    private Date data_saida;

    public void setData_saida(String data_saida) {
        try {
            this.data_saida = new SimpleDateFormat("dd-MM-yyyy").parse(data_saida);
        } catch (ParseException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    @Column(name = "tempo")
    @NotEmpty(message = "*Por favor forneça o tempo de permanencia")
    private String tempo;

    @Column(name = "valor_pago")
    @NotEmpty(message = "*Por favor forneça o valor pago")
    private String valor_pago;

}
