package br.com.java.sistemacontrolecarros.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.*;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    @Override
    public BigDecimal calcularPagamento(BigDecimal preco_Hora, BigDecimal hora) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tiket registrarSaida(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Autowired
    MovimentacaoRepository movimentoRepository;

    // @Autowired
    // TiketService tiketService;

    // @Autowired
    // PrecoService precoService;

    // @Autowired
    // MovimentacaoService movimentacaoService;

    // @Autowired
    // VeiculoService veiculoService;

    
    // public MovimentacaoServiceImpl(MovimentacaoRepository movimentoRepository) {
    //     this.movimentoRepository = movimentoRepository;
    // }

    // @Override
    // public BigDecimal calcularPagamento(BigDecimal preco_Hora, BigDecimal horas) {
    //     // TODO Auto-generated method stub
    //     BigDecimal valor_pago = preco_Hora.multiply(horas);
        
    //     return valor_pago;
    // }

    public Movimentacao registrarEntrada(Movimentacao movimentacao) {

        movimentacao.setData_entrada(LocalDate.now());
        movimentacao.setHora_entrada(LocalTime.now());

        return movimentoRepository.save(movimentacao);
    }
    // public Tiket registrarSaida(Movimentacao movimentacao) {

    //     Movimentacao movimentacaoSaindo = movimentoRepository.findById(movimentacao.getId()).get();
	// 	Movimentacao movimentacaoSaindoRegistrado = registrarHoraSaida(registrarDataSaida(movimentacaoSaindo));

    //     movimentoRepository.save(movimentacaoSaindoRegistrado);


    //     return tiketService.gerarCupomPagamento(movimentacaoSaindoRegistrado);
    // }

    // public Movimentacao registrarDataSaida(Movimentacao movimentacao) {
		
	// 	movimentacao.setData_saida(LocalDate.now());
		
	// 	return movimentacao;
	// }
    // public Movimentacao registrarHoraSaida(Movimentacao movimentacao) {
    //     movimentacao.setHora_saida(LocalTime.now());
        
    //     return movimentacao;
    // }


    @Override
    public Movimentacao buscarRegistroPorId(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        return movimentoRepository.findById(movimentacao.getId()).get();
    }

    @Override
    public Movimentacao preencherDadosManualmente(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        Movimentacao movimentacaoManual = new Movimentacao();
		movimentacaoManual.setData_entrada(movimentacao.getData_entrada());
		movimentacaoManual.setHora_entrada(movimentacao.getHora_entrada());
		movimentacaoManual.setVeiculo(movimentacao.getVeiculo());
		return movimentacaoManual;
    }
    
}
