package br.com.java.sistemacontrolecarros.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

// import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Integer id;

    @Column(name = "user_name")
    // @Length(min = 5, message = "*Seu nome de usuário deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor forneça um nome de usuário")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Por favor forneça um email válido")
    @NotEmpty(message = "*Por favor forneça um email")
    private String email;

    @Column(name = "password")
    // @Length(min = 5, message = "*Sua senha deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor forneça sua senha")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Por favor forneça seu nome")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "*Por favor forneça seu sobrenome")
    private String lastname;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
