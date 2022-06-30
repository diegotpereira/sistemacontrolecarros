package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.sistemacontrolecarros.models.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, String>{
    
}
