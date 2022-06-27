package br.com.java.sistemacontrolecarros.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    private final MovimentacaoRepository movimentoRepository;

    @Autowired
    public MovimentacaoServiceImpl(MovimentacaoRepository movimentoRepository) {
        this.movimentoRepository = movimentoRepository;
    }

    @Override
    public List<Movimentacao> findAll() {
        // TODO Auto-generated method stub
        List<Movimentacao> carros = new ArrayList<>();

        for(Movimentacao movimentacao : movimentoRepository.findAll()) {
            carros.add(movimentacao);
        }

        return carros;
    }

    @Override
    public void save(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Movimentacao getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movimentacao> getByPlaca(String placa) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movimentacao> getByModelo(String modelo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BigDecimal calcularDiferenca(Date horarioEntrada, Date horarioSaida) {
        // TODO Auto-generated method stub
        DateTime entrada = new DateTime(horarioEntrada);
        DateTime saida = new DateTime(horarioSaida);

        BigDecimal minutos = new BigDecimal(Minutes.minutesBetween(entrada, saida).getMinutes());
        BigDecimal horas = minutos.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
        return horas;
    }

    @Override
    public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal horas) {
        // TODO Auto-generated method stub
        BigDecimal totalPagar = precoHora.multiply(horas);
        
        return totalPagar;
    }
    
}
