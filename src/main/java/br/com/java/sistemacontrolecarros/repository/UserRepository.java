package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.sistemacontrolecarros.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
    User findByUserName(String userName);
}
