package br.com.java.sistemacontrolecarros.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Movimentacao;

@Service
public interface MovimentacaoService {

    List<Movimentacao> findAll();
    void save(Movimentacao movimentacao);
    Movimentacao getById(Long id);
    List<Movimentacao> getByPlaca(String placa);
    List<Movimentacao> getByModelo(String modelo);
    void deleteById(Long id);

}
