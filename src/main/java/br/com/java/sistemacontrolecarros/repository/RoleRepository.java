package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.sistemacontrolecarros.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role findByRole(String role);
}
