package br.com.java.sistemacontrolecarros.service;

import java.time.LocalTime;
import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.*;

@Service
public interface TiketService {

    public Tiket gerarCupomPagamento(Movimentacao movimentacao);
    public LocalTime calculaIntervaloDeTempo(Movimentacao movimentacao);
    public Double calcularValorBaseadoNoTempo(Double precoPorHora, Double precoHoraFracao, LocalTime intervaloDeTempo);
    public Boolean validaIntervaloDeTempo(Movimentacao movimentacao);
    
}
