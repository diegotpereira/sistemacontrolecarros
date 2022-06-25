package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.sistemacontrolecarros.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role findByRole(String role);
}
