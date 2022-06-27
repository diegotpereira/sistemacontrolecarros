package br.com.java.sistemacontrolecarros.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_valor")
public class Valor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="valor_id")
    private Integer id;

    @Column(name = "valor_primeira_hora")
    @NotEmpty(message = "*Por favor forneça o valor da primeira hora")
    private String valor_primeira_hora;

    @Column(name = "valor_demais_horas")
    @NotEmpty(message = "*Por favor forneça o valor das demais horas")
    private String valor_demais_horas;

    @Column(name = "data_fim")
    @NotEmpty(message = "*Por favor forneça de saída")
    private Date data_fim;
}
