package br.com.java.sistemacontrolecarros.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.repository.TiketRepository;
import br.com.java.sistemacontrolecarros.service.*;

@Service
public class TiketServiceImpl implements TiketService{

    @Autowired
    MovimentacaoService movimentacaoService;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    PrecoService precoService;

    @Autowired
    TiketRepository tiketRepository;

    @Override
    public Tiket gerarCupomPagamento(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        Movimentacao movimentacaoComSaidaRegistrada = movimentacaoService.buscarRegistroPorId(movimentacao);

        LocalDate dataEntrada = movimentacaoComSaidaRegistrada.getData_entrada();
		LocalDate dataSaida = movimentacaoComSaidaRegistrada.getData_saida();
		LocalTime horaEntrada = movimentacaoComSaidaRegistrada.getHora_entrada();
		LocalTime horaSaida = movimentacaoComSaidaRegistrada.getHora_saida();

        Veiculo veiculoSaida = veiculoService.buscarPorId(movimentacaoComSaidaRegistrada.getVeiculo());

        String tipoVeiculoSaida = veiculoSaida.getTipoVeiculo();
        String placaVeiculoSaida = veiculoSaida.getPlaca();
        // String modeloVeiculoSaida = veiculoSaida.getModelo();

        Preco precoPorTempo = precoService.buscar(veiculoSaida);

        Double precoPorHora = precoPorTempo.getPrecoHora();
        Double precoHoraFracao = precoPorTempo.getPrecoHoraFracao();

        LocalTime intervaloDeTempo = calculaIntervaloDeTempo(movimentacao);

        Double valorTotal = calcularValorBaseadoNoTempo(precoPorHora, precoHoraFracao, intervaloDeTempo);

        Tiket cupoPagamento = new Tiket();
        cupoPagamento.setTipoVeiculo(tipoVeiculoSaida);
        cupoPagamento.setVeiculoPlaca(placaVeiculoSaida);
        cupoPagamento.setDataEntrada(dataEntrada);
        cupoPagamento.setDataSaida(dataSaida);
        cupoPagamento.setHoraEntrada(horaEntrada);
        cupoPagamento.setHoraSaida(horaSaida);
        cupoPagamento.setPrecoHora(precoPorHora);
        cupoPagamento.setValorTotal(valorTotal);

        return tiketRepository.save(cupoPagamento);
    }

    @Override
    public LocalTime calculaIntervaloDeTempo(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        return movimentacao.getHora_saida()
        .minusHours(movimentacao.getHora_entrada()
        .getHour())
        .minusMinutes(movimentacao.getHora_entrada().getMinute());
    }

    @Override
    public Double calcularValorBaseadoNoTempo(Double precoPorHora, Double precoHoraFracao, LocalTime intervaloDeTempo) {
        // TODO Auto-generated method stub
        int primeiraHora = 0;

        // Busca o valor de hora e minuto
        Integer tempoTotalHoras = intervaloDeTempo.getHour();
        Integer tempoTotalMinutos = intervaloDeTempo.getMinute();

        if (tempoTotalMinutos >= 0) {
            
            primeiraHora = precoPorHora.intValue();

        } 
        
        Double valorHoras = tempoTotalHoras * precoPorHora;
        Double valorDemaisHoras = (tempoTotalMinutos / 4 ) * precoHoraFracao;

        Double valorTotal = valorHoras + valorDemaisHoras + primeiraHora;

        return valorTotal;
    }

    @Override
    public Boolean validaIntervaloDeTempo(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        if (movimentacao.getData_entrada().isAfter(movimentacao.getData_saida())) {
            throw new RuntimeException("Erro! Data de entrada ?? posterior a data de sa??da.");
        } else if (movimentacao.getHora_entrada().isAfter(movimentacao.getHora_saida())) {
            throw new RuntimeException("Erro! hora de entrada ?? posterior a hora de sa??da.");
        }
        return true;
    }
    
}
