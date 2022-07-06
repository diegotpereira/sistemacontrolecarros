package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.java.sistemacontrolecarros.models.Tiket;

@Repository
public interface TiketRepository extends JpaRepository<Tiket, Long>{
    
}
