package br.com.java.sistemacontrolecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.java.sistemacontrolecarros.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    
}
