package br.com.java.sistemacontrolecarros.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.models.Tiket;

@Service
public interface MovimentacaoService {
    
	public BigDecimal calcularPagamento(BigDecimal preco_Hora, BigDecimal hora);
    public Movimentacao registrarEntrada(Movimentacao movimentacao);
    public Tiket registrarSaida(Movimentacao movimentacao);
    public Movimentacao buscarRegistroPorId(Movimentacao movimentacao);
    public Movimentacao preencherDadosManualmente(Movimentacao movimentacao);
}
