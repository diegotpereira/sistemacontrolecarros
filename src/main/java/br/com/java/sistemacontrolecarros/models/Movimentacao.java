package br.com.java.sistemacontrolecarros.models;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @Column(name="veiculo_id")
    private Integer id;

    @Column(name = "placa")
    @NotEmpty(message = "*Por favor forneça uma placa")
    private String placa;

    @Column(name = "modelo")
    @NotEmpty(message = "*Por favor forneça um modelo")
    private String modelo;

    @Column(name = "data_entrada")
    @NotEmpty(message = "*Por favor forneça uma data de entrada")
    private LocalDateTime data_entrada;

    @Column(name = "data_saida")
    @NotEmpty(message = "*Por favor forneça uma data de saída")
    private LocalDateTime data_saida;

    @Column(name = "tempo")
    @NotEmpty(message = "*Por favor forneça o tempo de permanencia")
    private String tempo;

    @Column(name = "valor_pago")
    @NotEmpty(message = "*Por favor forneça o valor pago")
    private String valor_pago;

}
