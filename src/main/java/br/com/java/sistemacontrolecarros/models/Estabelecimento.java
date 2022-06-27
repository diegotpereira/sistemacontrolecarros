package br.com.java.sistemacontrolecarros.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_veiculos")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estabecimento_id")
    private int id;

    @Column(name = "estabelecimento_nome")
    @NotEmpty(message = "*Por favor forneça um nome de estabelcimento")
    private String nome;

    
    @Column(name = "cnpj")
    @NotEmpty(message = "*Por favor fornceça um cnpj")
    private String cnpj;

    @Column(name = "endereço")
    @NotEmpty(message = "*Por favor forneça um endereço de estabelecimento")
    private String endereco;
    
}
