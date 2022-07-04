package br.com.java.sistemacontrolecarros.service;

import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.models.Tiket;

@Service
public interface MovimentacaoService {

    public Movimentacao registrarEntrada(Movimentacao movimentacao);
    public Tiket registrarSaida(Movimentacao movimentacao);
    public Movimentacao buscarRegistroPorId(Movimentacao movimentacao);
    public Movimentacao preencherDadosManualmente(Movimentacao movimentacao);
}
