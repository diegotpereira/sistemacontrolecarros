package br.com.java.sistemacontrolecarros.service.impl;

import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.repository.*;
import br.com.java.sistemacontrolecarros.service.*;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    VeiculoRepository veiculoRepository;
    
    @Autowired
    MovimentacaoRepository movimentoRepository;

    @Autowired
    TiketService tiketService;

    public Movimentacao registrarEntrada(Movimentacao movimentacao) {

        movimentacao.setData_entrada(LocalDate.now());
        movimentacao.setHora_entrada(LocalTime.now());
    
        return movimentoRepository.save(movimentacao);
    }
    public Tiket registrarSaida(Movimentacao movimentacao) {

        Movimentacao movimentacaoSaindo = movimentoRepository.findById(movimentacao.getId()).get();
		Movimentacao movimentacaoSaindoRegistrado = registrarHoraSaida(registrarDataSaida(movimentacaoSaindo));

        movimentoRepository.save(movimentacaoSaindoRegistrado);
        return tiketService.gerarCupomPagamento(movimentacaoSaindoRegistrado);
    }

    public Movimentacao registrarDataSaida(Movimentacao movimentacao) {
		
		movimentacao.setData_saida(LocalDate.now());
		
		return movimentacao;
	}
    public Movimentacao registrarHoraSaida(Movimentacao movimentacao) {
        movimentacao.setHora_saida(LocalTime.now());
        
        return movimentacao;
    }


    @Override
    public Movimentacao buscarRegistroPorId(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        return movimentoRepository.findById(movimentacao.getId()).get();
    }

    @Override
    public Movimentacao preencherDadosManualmente(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        
		movimentacao.setData_entrada(movimentacao.getData_entrada());
		movimentacao.setHora_entrada(movimentacao.getHora_entrada());
        movimentacao.setVeiculo(movimentacao.getVeiculo());
		
		return movimentacao;
    }
    public void atualizar(Movimentacao movimentacao) {
        movimentacaoRepository.save(movimentacao);
    }
}
